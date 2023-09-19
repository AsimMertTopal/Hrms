package Hrms.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Hrms.business.abstracts.JobAdvertisementService;
import Hrms.business.response.AllActiveJobAdversiments;
import Hrms.core.utilities.results.DataResult;
import Hrms.core.utilities.results.ErrorDataResult;
import Hrms.core.utilities.results.Result;
import Hrms.entities.concretes.JobAdvertisement;


@Configuration
@RestController
@RequestMapping("api/jobAdversiments")
public class JobAdvertisementsController {
private final JobAdvertisementService advertisementService;
	
	
    @Autowired
    public JobAdvertisementsController(JobAdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
       
    }
    @GetMapping("/add")
    public Result add (JobAdvertisement jobAdvertisement) {
     return this.advertisementService.add(jobAdvertisement);
    	
    }
	
	@GetMapping("/all")
	public DataResult<List<AllActiveJobAdversiments>> findAlll(){
		return this.advertisementService.findAlll();
		
	}
	@GetMapping("/updateStatus")
	public Result updateStatus( int id) {
		return this.advertisementService.updateStatus(id);
		
	} 
	@GetMapping("/approvalJobAdvertisement")
	public Result approvalJobAdvertisement() {
		return this.advertisementService.approvalJobAdvertisement();
	}
    @GetMapping("getAllDesc")
	public DataResult<List<AllActiveJobAdversiments>> getAllSortedByReleaseDate(){
		return this.advertisementService.getByreleaseDateDesc();
		
	}
    
    @GetMapping("getByCompanyName")
	public DataResult<List<AllActiveJobAdversiments>> getByCompanyName(String companyName){
		return this.advertisementService.getByCompanyName(companyName);
		
	}
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object>handleValidationException(MethodArgumentNotValidException exceptions){
  	  Map<String,String> validationErrors=new HashMap<String,String>();
  	  for(FieldError fieldError:exceptions.getBindingResult().getFieldErrors()) {
  		 validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage()); 
  	  }
  	  ErrorDataResult<Object> errors=new ErrorDataResult<>(validationErrors, "Doğrulama Hataları.");
  	  return errors;
    }
   
}
