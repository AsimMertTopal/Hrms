package Hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Hrms.business.abstracts.WorkHistoryService;
import Hrms.core.utilities.results.DataResult;
import Hrms.core.utilities.results.Result;
import Hrms.entities.concretes.WorkHistory;

@RestController
@RequestMapping("api/workHistory")
@Configuration
public class WorkHistoryController {
	
  WorkHistoryService workHistoryService;

    @Autowired
	public WorkHistoryController(WorkHistoryService workHistoryService) {
	this.workHistoryService = workHistoryService;
}
    @PostMapping("/add")
	public Result add(WorkHistory workHistory) {
		return this.workHistoryService.add(workHistory);
		
		
	}
    
    @GetMapping("/findyByLeavingJobYearDesc")
    public DataResult<List< WorkHistory>> findByOrderByLeavingJobYearDesc(){
    	return this.findByOrderByLeavingJobYearDesc();
    }
}
