package Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Hrms.business.abstracts.EducationInformationService;
import Hrms.core.utilities.results.DataResult;
import Hrms.core.utilities.results.Result;
import Hrms.core.utilities.results.SuccessDataResult;
import Hrms.core.utilities.results.SuccessResult;
import Hrms.dataAccess.abstracts.EducationInformationDao;
import Hrms.entities.concretes.EducationInformation;
@Service
public class EducationInformationManager implements EducationInformationService {
	EducationInformationDao educationInformationDao;
	
	@Autowired
	public EducationInformationManager(EducationInformationDao educationInformationDao) {
		this.educationInformationDao=educationInformationDao;
	}

	@Override
	public Result add(EducationInformation educationInformation) {
		EducationInformation educationInformationadd = new EducationInformation();
		educationInformationadd.setSchoolName(educationInformation.getSchoolName());
		educationInformationadd.setDepartment(educationInformation.getDepartment());
		educationInformationadd.setStartYear(educationInformation.getStartYear());
		educationInformationadd.setGraduationYear(educationInformation.getGraduationYear());
		educationInformationDao.save(educationInformation);
		return new SuccessResult("Eğitim Bilgileri girildi");
	}
	   

	@Override
	public DataResult<List<EducationInformation>> findByOrderByGraduationYearDesc() {
		//try catch yazılacak
		List<EducationInformation> educationInformationList = educationInformationDao.findByOrderByGraduationYearDesc();
		educationInformationList.forEach(educationInfo  ->{
			if(educationInfo.getGraduationYear() == -1) {
				educationInfo.setSchoolName("Devam Ediyor");
				educationInfo.setDepartment("Mezun Değil");			
			}		
		});
		
		
		return new SuccessDataResult<List<EducationInformation>>
		( this.educationInformationDao.findByOrderByGraduationYearDesc(),"Mezuniyet Yılları Tersten Sıralandı");
	}

}
