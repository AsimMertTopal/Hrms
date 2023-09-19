package Hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Hrms.business.abstracts.JobAdvertisementService;
import Hrms.business.response.AllActiveJobAdversiments;
import Hrms.core.utilities.results.DataResult;
import Hrms.core.utilities.results.ErrorDataResult;
import Hrms.core.utilities.results.ErrorResult;
import Hrms.core.utilities.results.Result;
import Hrms.core.utilities.results.SuccessDataResult;
import Hrms.core.utilities.results.SuccessResult;
import Hrms.dataAccess.abstracts.EmployerDao;
import Hrms.dataAccess.abstracts.JobAdvertisementDao;
import Hrms.dataAccess.abstracts.JobPositionDao;
import Hrms.entities.concretes.Employer;
import Hrms.entities.concretes.JobAdvertisement;
import Hrms.entities.concretes.JobPosition;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
	JobAdvertisementDao advertisementDao;
	EmployerDao employerDao;
	JobPositionDao positionDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao advertisementDao,EmployerDao employerDao,JobPositionDao positionDao) {
		this.advertisementDao=advertisementDao;
		this.employerDao = employerDao;
		this.positionDao = positionDao;
		
	}
	
	
	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		  JobAdvertisement jobAdvertisement2 = new JobAdvertisement();
		  jobAdvertisement2.setName(jobAdvertisement.getName());
		  jobAdvertisement2.setJobDescription(jobAdvertisement.getJobDescription());
		  jobAdvertisement2.setOpenPositionCount(jobAdvertisement.getOpenPositionCount());
		  jobAdvertisement2.setReleaseDate(jobAdvertisement.getReleaseDate());
		  jobAdvertisement2.setApplicationDeadline(jobAdvertisement.getApplicationDeadline());
		  jobAdvertisement2.setWage(jobAdvertisement.getWage());
		  jobAdvertisement2.setJobAdvertisementStatus(0);
		  advertisementDao.save(jobAdvertisement2);
		  
		  return new SuccessDataResult<Object>("İş İlanı Eklendi Aktif Edilmesi Bekleniyor.");
		
		
	}
	@Override
	public Result approvalJobAdvertisement() {
		List<JobAdvertisement> approvalJobAdvertisement;
		//try catch
		approvalJobAdvertisement=this.advertisementDao.getByjobAdvertisementStatus(0);
		if(approvalJobAdvertisement.isEmpty()) {
			return new ErrorDataResult<Object>("Liste Boş");
		} 
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.advertisementDao.getByjobAdvertisementStatus(0),"Onay Bekleyen İlanlar Getirildi");
	}

	
	@Override
	public Result updateStatus(int id) {
		try {
			JobAdvertisement jobAdvertisementValidation;
			jobAdvertisementValidation=this.advertisementDao.getByid(id);
			if (jobAdvertisementValidation.getJobAdvertisementStatus()==0) {
				jobAdvertisementValidation.setJobAdvertisementStatus(1);
				advertisementDao.save(jobAdvertisementValidation);
				return new SuccessResult("İlan Aktifleştirildi");
			}
			return new ErrorResult("İlan Zaten Aktif");
		}catch (Exception e) {
			return new ErrorResult("İlan Bulunamadı !");

		}
	}
	
	
	@Override
	public DataResult<List<AllActiveJobAdversiments>> findAlll() {
		//try catch
		
		List<JobAdvertisement> activeStatus = advertisementDao.findByjobAdvertisementStatusGreaterThan(0);
		List<AllActiveJobAdversiments> allActiveJobAdversiment = new ArrayList<AllActiveJobAdversiments>();		
		
		Employer employer = new Employer();
		JobPosition jobPosition = new JobPosition();
		List<JobAdvertisement> jobAdversiment;
		jobAdversiment = advertisementDao.findAll();
		
		for(int i =0;i<activeStatus.size();i++) {
			AllActiveJobAdversiments activeJobAdversiments = new AllActiveJobAdversiments();
			int employerId = activeStatus.get(i).getEmployerId();
			employer =  employerDao.getById(employerId);			
			int jobPositionId = activeStatus.get(i).getJobPositionId();
			jobPosition = positionDao.getById(jobPositionId);		
			activeJobAdversiments.setCompanyName(employer.getCompanyName());
			activeJobAdversiments.setJobPosition(jobPosition.getJobName());
			activeJobAdversiments.setOpenPositionCount(jobAdversiment.get(i).getOpenPositionCount());
			activeJobAdversiments.setReleaseDate(jobAdversiment.get(i).getReleaseDate());
			activeJobAdversiments.setApplicationDeadline(jobAdversiment.get(i).getApplicationDeadline());
			allActiveJobAdversiment.add(activeJobAdversiments);		
		}
		
		
		return new DataResult<List<AllActiveJobAdversiments>>(allActiveJobAdversiment, true, "Aktif İş İlanları Listelendi");
	}


	@Override
	public DataResult<List<AllActiveJobAdversiments>> getByreleaseDateDesc() {
		List<JobAdvertisement> activeStatus = advertisementDao.findByJobAdvertisementStatusGreaterThanOrderByReleaseDateDesc(0);
		List<AllActiveJobAdversiments> allActiveJobAdversiment = new ArrayList<AllActiveJobAdversiments>();		
		
		Employer employer = new Employer();
		JobPosition jobPosition = new JobPosition();
		List<JobAdvertisement> jobAdversiment;
		jobAdversiment = advertisementDao.findAll();
		
		
		for(int i =0;i<activeStatus.size();i++) {
			AllActiveJobAdversiments activeJobAdversiments = new AllActiveJobAdversiments();
			int employerId = activeStatus.get(i).getEmployerId();
		
			employer =  employerDao.getById(employerId);
			
			
			int jobPositionId = activeStatus.get(i).getJobPositionId();
			jobPosition = positionDao.getById(jobPositionId);
			
			
			activeJobAdversiments.setCompanyName(employer.getCompanyName());
			activeJobAdversiments.setJobPosition(jobPosition.getJobName());
			activeJobAdversiments.setOpenPositionCount(jobAdversiment.get(i).getOpenPositionCount());
			activeJobAdversiments.setReleaseDate(jobAdversiment.get(i).getReleaseDate());
			activeJobAdversiments.setApplicationDeadline(jobAdversiment.get(i).getApplicationDeadline());
			allActiveJobAdversiment.add(activeJobAdversiments);
			
		}
		return new DataResult<List<AllActiveJobAdversiments>>(allActiveJobAdversiment, true, "Yeni Tarihten Eski Tarihe Göre Sıralandı");
	}


	@Override
	public DataResult<List<AllActiveJobAdversiments>> getByCompanyName(String companyName) {
		Employer employer=new Employer();
		JobPosition jobPosition = new JobPosition();

		employer=this.employerDao.getBycompanyName(companyName);
		List<AllActiveJobAdversiments> allActiveJobAdversiment = new ArrayList<AllActiveJobAdversiments>();	
		
		List<JobAdvertisement> activeJobAdvertisements;
		activeJobAdvertisements=this.advertisementDao.findByEmployerIdAndJobAdvertisementStatus(employer.getId(),1);
		for(int i=0;i<activeJobAdvertisements.size();i++) {
			
			int jobPositionId = activeJobAdvertisements.get(i).getJobPositionId();
			jobPosition = positionDao.getById(jobPositionId);
			AllActiveJobAdversiments allActiveJobAdversiments=new AllActiveJobAdversiments();
			allActiveJobAdversiments.setCompanyName(employer.getCompanyName());
			allActiveJobAdversiments.setJobPosition(jobPosition.getJobName());
			allActiveJobAdversiments.setOpenPositionCount(activeJobAdvertisements.get(i).getOpenPositionCount());
			allActiveJobAdversiments.setReleaseDate(activeJobAdvertisements.get(i).getReleaseDate());
			allActiveJobAdversiments.setApplicationDeadline(activeJobAdvertisements.get(i).getApplicationDeadline());
			
			allActiveJobAdversiment.add(allActiveJobAdversiments);
			
		}
		
		return  new DataResult<List<AllActiveJobAdversiments>>(allActiveJobAdversiment, true, "Yeni Tarihten Eski Tarihe Göre Sıralandı");
	}








}
