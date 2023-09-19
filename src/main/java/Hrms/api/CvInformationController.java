package Hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Hrms.business.abstracts.CvInformationService;
import Hrms.business.response.CvDetails;
import Hrms.core.utilities.results.DataResult;
import Hrms.core.utilities.results.Result;
import Hrms.entities.concretes.CvInformation;

@RestController
@Configuration
@RequestMapping("api/cv_information")
public class CvInformationController {
private CvInformationService cvInformationService;

@Autowired
public CvInformationController(CvInformationService cvInformationService) {
this.cvInformationService=cvInformationService;
    }

@PostMapping("/add")
 public Result add(CvInformation cvInformation) {
	 return this.cvInformationService.add(cvInformation);
	 
 }
@GetMapping("/all")
public DataResult<List<CvDetails>> findAlll(){
	return this.cvInformationService.findAlll();
	
}
}
