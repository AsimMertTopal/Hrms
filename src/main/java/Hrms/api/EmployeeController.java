package Hrms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Hrms.business.abstracts.EmployeeService;
import Hrms.entities.concretes.Employee;


@Configuration
@RestController
@RequestMapping("api/employee")
public class EmployeeController {
	private final EmployeeService employeeService;
	
	
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
       
    }
    
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public boolean add(@RequestBody Employee employee) {
		
		return this.employeeService.add(employee);
		
	}

}
