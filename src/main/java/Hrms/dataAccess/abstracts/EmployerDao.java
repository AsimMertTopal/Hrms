package Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Hrms.entities.concretes.Employer;


public interface EmployerDao extends JpaRepository<Employer, Integer>{
	
	Employer getById(int id);
	
	List<Employer>findAll();
	List<Employer>findBywebSiteStartingWith(String webSite);
	List<Employer>findByeMail(String eMail);
	List<Employer> getByemployerStatus(int employerStatus);

	

}

