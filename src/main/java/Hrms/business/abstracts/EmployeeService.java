package Hrms.business.abstracts;

import java.util.List;

import Hrms.core.utilities.results.DataResult;
import Hrms.entities.concretes.Employee;

public interface EmployeeService {
	boolean add(Employee employee);
	void delete();
	void update();
	List<Employee>getAll();
	DataResult<List<Employee>> findAll();
}
