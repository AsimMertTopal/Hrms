 package Hrms.business.abstracts;

import java.util.List;

import Hrms.core.utilities.results.DataResult;
import Hrms.core.utilities.results.Result;
import Hrms.entities.concretes.Employer;


public interface EmployerService {
Result add(Employer employer);
	
Result notSave();
	

Result updateStatus(int id);

DataResult<List<Employer>> findAll();


}
