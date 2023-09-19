package Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Hrms.entities.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee,Integer> {
	Employee getById(int id);

	List<Employee> findAll();
	List<Employee> findByeMail(String eMail);
	List<Employee> findBynationalIdentity(String nationalIdentity);
//	List<Employee> findBynationalIdentity(int nationalIdentity);
	
}
