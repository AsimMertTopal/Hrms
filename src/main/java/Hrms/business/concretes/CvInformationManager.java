package Hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Hrms.business.abstracts.CvInformationService;
import Hrms.business.response.CvDetails;
import Hrms.core.utilities.results.DataResult;
import Hrms.core.utilities.results.Result;
import Hrms.core.utilities.results.SuccessResult;
import Hrms.dataAccess.abstracts.CvInformationDao;
import Hrms.dataAccess.abstracts.EducationInformationDao;
import Hrms.dataAccess.abstracts.EmployeeDao;
import Hrms.dataAccess.abstracts.WorkHistoryDao;
import Hrms.entities.concretes.CvInformation;
import Hrms.entities.concretes.EducationInformation;
import Hrms.entities.concretes.Employee;
import Hrms.entities.concretes.WorkHistory;

@Service
public class CvInformationManager implements CvInformationService {
  CvInformationDao cvInformationDao;
  EmployeeDao employeeDao;
  WorkHistoryDao workHistoryDao;
  EducationInformationDao educationInformationDao;
  
  @Autowired
  public CvInformationManager(CvInformationDao cvInformationDao,  EmployeeDao employeeDao,  WorkHistoryDao workHistoryDao,
		  EducationInformationDao educationInformationDao) {
	
	this.cvInformationDao = cvInformationDao;
	this.employeeDao = employeeDao;
	this.workHistoryDao = workHistoryDao;
	this.educationInformationDao = educationInformationDao;

}

  @Override
	public Result add(CvInformation cvInformation) {
		cvInformation.setLanguageName(cvInformation.getLanguageName());
		cvInformation.setLanguageLevel(cvInformation.getLanguageLevel());
		cvInformation.setAboutYourSelf(cvInformation.getAboutYourSelf());
		cvInformation.setProgramming(cvInformation.getProgramming());
		cvInformation.setLinkedinUrl(cvInformation.getLinkedinUrl());
		cvInformation.setGithubUrl(cvInformation.getGithubUrl());
		cvInformationDao.save(cvInformation);
		return new SuccessResult("Cv Eklendi");
	}

	@Override
	public DataResult<List<CvDetails>> findAlll()
	 {
		List<CvInformation> cvInformationList=cvInformationDao.findAll();
		List<CvDetails> cvDetailsList=new ArrayList<CvDetails>();

		Employee employee=new Employee();
		WorkHistory workHistory=new WorkHistory();
		EducationInformation educationInformation=new EducationInformation();
		List<CvInformation> cvInformations;
		cvInformations=cvInformationDao.findAll();
		
		//Gelen veri boş işe bir koşul yazılacak if ile yada try catch ile
		for(int i=0;i<cvInformationList.size();i++) {			
		CvDetails cvDetails=new CvDetails();
		
		int employeeId=cvInformationList.get(i).getEmployeeId();
		employee=employeeDao.getById(employeeId);
		int workHistoryId=cvInformationList.get(i).getWorkHistoryId();
		workHistory=workHistoryDao.getById(workHistoryId);
		int educationInformationId=cvInformationList.get(i).getEducationInformationId();
		educationInformation=educationInformationDao.getById(educationInformationId);
		
		
		cvDetails.setFirstName(employee.getFirstName());
		cvDetails.setLastName(employee.getLastName());
		cvDetails.setNationalIdentity(employee.getNationalIdentity());
		cvDetails.setBirthYear(employee.getBirthYear());
		cvDetails.setEMail(employee.getEMail());
	    cvDetails.setSchoolName(educationInformation.getSchoolName());
	    cvDetails.setDepartment(educationInformation.getDepartment());
	    cvDetails.setStartYear(educationInformation.getStartYear());
	    cvDetails.setGraduationYear(educationInformation.getGraduationYear());
		cvDetails.setWorkName(workHistory.getWorkName());
		cvDetails.setWorkingPosition(workHistory.getWorkingPosition());
		cvDetails.setJobStartYear(workHistory.getJobStartYear());
		cvDetails.setLeavingJobYear(workHistory.getLeavingJobYear());
		cvDetails.setLanguageName(cvInformations.get(i).getLanguageName());
		cvDetails.setLanguageLevel(cvInformations.get(i).getLanguageLevel());
		cvDetails.setAboutYourSelf(cvInformations.get(i).getAboutYourSelf());
		cvDetails.setProgramming(cvInformations.get(i).getProgramming());
		cvDetails.setLinkedinUrl(cvInformations.get(i).getLinkedinUrl());
		cvDetails.setGithubUrl(cvInformations.get(i).getGithubUrl());
		cvDetailsList.add(cvDetails);
		}
		
		return new DataResult<List<CvDetails>>(cvDetailsList,true,"Cv Bilgileri Listelendi");
	}
	

}
