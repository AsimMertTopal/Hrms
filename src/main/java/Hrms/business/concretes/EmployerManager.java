package Hrms.business.concretes;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Hrms.business.abstracts.EmployerService;
import Hrms.core.utilities.results.DataResult;
import Hrms.core.utilities.results.ErrorDataResult;
import Hrms.core.utilities.results.ErrorResult;
import Hrms.core.utilities.results.Result;
import Hrms.core.utilities.results.SuccessDataResult;
import Hrms.core.utilities.results.SuccessResult;
import Hrms.dataAccess.abstracts.EmployerDao;
import Hrms.entities.concretes.Employer;


@Service
public class EmployerManager implements EmployerService{
	EmployerDao employerDao;
	
	
	@Autowired
	public EmployerManager( EmployerDao employerDao) {
		this.employerDao=employerDao;
		
	}
	
	@Override
	public Result add(Employer employer) {
	Employer employerSignUp =new Employer();
	List<Employer> employerList = this.employerDao.findAll();
	boolean eMailRules = Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", employer.getEMail());
	if (!eMailRules){
		return new ErrorResult("Mail adresinde kullanılan karakterler hatalı !");
	}else {
		if(employerList.isEmpty()) {
			
			employerSignUp.setCompanyName(employer.getCompanyName());
			employerSignUp.setEMail(employer.getEMail());
			employerSignUp.setTelephoneNumber(employer.getTelephoneNumber());
			employerSignUp.setPassword(employer.getPassword());
			employerSignUp.setPasswordRepate(employer.getPasswordRepate());
			employerSignUp.setEmployerStatus(0);
			employerDao.save(employer);
			return new SuccessResult("İş Veren Eklendi");
			
		}else {
			
			String mail[] = employer.getEMail().split("@");
			String webDomain[] = employer.getWebSite().split("\\.");		
			System.out.println(webDomain[1]);
			System.out.println(mail[0].contains(webDomain[1]));
			List<Employer> existingList=this.employerDao.findByeMail(employer.getEMail());		
			 if(!existingList.isEmpty() || !employer.getPassword().equals(employer.getPasswordRepate()) || !mail[0].contains(webDomain[1])) {		 
				 return new ErrorResult("Kullanıcı bilgileri Hatalı E mail ya da şifre");
			 }
			
			
		}
		employerSignUp.setCompanyName(employer.getCompanyName());
		employerSignUp.setEMail(employer.getEMail());
		employerSignUp.setTelephoneNumber(employer.getTelephoneNumber());
		employerSignUp.setPassword(employer.getPassword());
		employerSignUp.setPasswordRepate(employer.getPasswordRepate()); 
		employerSignUp.setEmployerStatus(0);
		employerDao.save(employer);
		return new SuccessResult("İş Veren Eklendi");
	}                           
	
		
	}



	@Override
	public Result notSave() {
		List<Employer> zeroStatus;
		zeroStatus = this.employerDao.getByemployerStatus(0);
		System.out.println(zeroStatus);
		if(zeroStatus.isEmpty()) {
			return new ErrorDataResult<List<Employer>>("Liste Getirilemedi");
		}		
		return new SuccessDataResult<List<Employer>>(zeroStatus, "Data Listelendi", true);
	}

	@Override
	public Result updateStatus(int id) {
		try {
		Employer employerValidation;
		employerValidation=this.employerDao.getById(id);
		if(employerValidation.getEmployerStatus()==0) {
			employerValidation.setEmployerStatus(1);
			employerDao.save(employerValidation);
			return new SuccessResult("Kullanıcı Aktifleştirildi");
		} 
			
			
			
			return new ErrorResult("Kullanıcı Zaten Aktif");
		}catch (Exception e) {
			return new ErrorResult("Kullanıcı Bulunamadı ! ");
		}
		
		
		
		
	}

}