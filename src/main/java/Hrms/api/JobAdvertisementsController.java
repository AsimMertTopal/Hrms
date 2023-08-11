package Hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Hrms.business.abstracts.JobAdvertisementService;
import Hrms.business.response.AllActiveJobAdversiments;
import Hrms.core.utilities.results.DataResult;

@Configuration
@RestController
@RequestMapping("api/jobAdversiments")
public class JobAdvertisementsController {
private final JobAdvertisementService advertisementService;
	
	
    @Autowired
    public JobAdvertisementsController(JobAdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
       
    }
    
	
	@GetMapping("/all")
	public DataResult<List<AllActiveJobAdversiments>> findAlll(){
		return this.advertisementService.findAlll();
		
	}

}
