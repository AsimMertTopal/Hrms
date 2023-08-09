package Hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Hrms.business.abstracts.JobPositionService;
import Hrms.core.utilities.results.DataResult;
import Hrms.core.utilities.results.Result;
import Hrms.entities.concretes.JobPosition;
@RestController
@RequestMapping("api/jobpositionservice")
@Configuration
public class JobPositionController {
	private final JobPositionService jobPositionService;
	@Autowired
	public JobPositionController(JobPositionService jobPositionService) {
		this.jobPositionService=jobPositionService;
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody  JobPosition jobPosition) {
		return this.jobPositionService.add(jobPosition);
		
	} 
	@PostMapping ("/delete")
	public Result delete(@RequestBody  JobPosition jobPosition) {
		return this.jobPositionService.add(jobPosition);
		
	} 
	
	@PostMapping("/update")
	public Result update(@RequestBody  JobPosition jobPosition) {
		return this.jobPositionService.add(jobPosition);
		
	} 
	@PostMapping("/get")
	DataResult <List<JobPosition>> getByJobName(@RequestBody  String jobName) {
		return this.jobPositionService.getByJobName(jobName);
		
	} 
	
	
	

}
