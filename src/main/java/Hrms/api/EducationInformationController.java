package Hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Hrms.business.abstracts.EducationInformationService;
import Hrms.core.utilities.results.DataResult;
import Hrms.core.utilities.results.Result;
import Hrms.entities.concretes.EducationInformation;

@RestController
@RequestMapping("api/educationInformation")
@Configuration
public class EducationInformationController {
	EducationInformationService educationInformationService;
	
	@Autowired
	public EducationInformationController(EducationInformationService educationInformationService) {
		this.educationInformationService=educationInformationService;
	}
	
	@PostMapping("/add")
	public Result add(EducationInformation educationInformation) {
		return this.educationInformationService.add(educationInformation);
		
	}
	@GetMapping("/findByGraduationYear")
	public DataResult<List<EducationInformation>> findByOrderByGraduationYearDesc(){
		return this.educationInformationService.findByOrderByGraduationYearDesc();
	}

}
