package Hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Hrms.business.abstracts.EmployerService;
import Hrms.core.utilities.results.DataResult;
import Hrms.core.utilities.results.Result;
import Hrms.entities.concretes.Employer;


@Configuration
@RestController
@RequestMapping("api/employeer")
public class EmployerController {
	EmployerService employerService;
	
	@Autowired
	public EmployerController(EmployerService employerService) {
		this.employerService=employerService;
		
	}
	@PostMapping("/add")
   public Result add (@RequestBody Employer employer) {
	return this.employerService.add(employer);
	   
   }
	
	@GetMapping("/get")
	public Result notSave () {
		return this.employerService.notSave();		   
	}
	
	@PostMapping("/updateStatus")
	   public Result updateStatus (@RequestBody int id) {
		return this.employerService.updateStatus(id);
		   
	   }
	@GetMapping("/getAllEmployer")
	public DataResult<List<Employer>>findAll(){
		return this.employerService.findAll();
	}
	
	

}
