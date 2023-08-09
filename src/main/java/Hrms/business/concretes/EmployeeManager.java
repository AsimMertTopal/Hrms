package Hrms.business.concretes;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Hrms.business.abstracts.EmployeeService;
import Hrms.core.utilities.MailService;
import Hrms.dataAccess.abstracts.EmployeeDao;
import Hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService {

	EmployeeDao employeeDao;
	MailService mailService;
	

	@Autowired
	public EmployeeManager(EmployeeDao employeeDao,MailService mailService) {
		this.employeeDao = employeeDao;
		this.mailService=mailService;
	}

	@Override
	public boolean add(Employee employee) {
		Employee employee3 = new Employee();

		List<Employee> employeeList = this.employeeDao.findAll();

		boolean a = Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", employee.getEMail());
		if (!a) {
			System.out.println("Mail adresinde kullanılan karakterler hatalı !");
			return false;
		} else {
			
			if (employeeList.isEmpty()) {
				employee3.setBirthYear(employee.getBirthYear());
				employee3.setEMail(employee.getEMail());
				employee3.setFirstName(employee.getFirstName());
				employee3.setLastName(employee.getLastName());
				employee3.setNationalIdentity(employee.getNationalIdentity());
				employee3.setPassword(employee.getPassword());
				employee3.setPasswordRepeat(employee.getPasswordRepeat());
				mailService.postMail("E mail Hesabınıza Aktivasyon Linki Gönderildi ");
				mailService.isCheckMail(true);
				employeeDao.save(employee3);
				return true;
			} else {
				for (int i=0;i<employeeList.size();i++) {
					List<Employee> existingEmployees = employeeDao.findByeMail(employee.getEMail());
					List<Employee>existingEmployees2 = employeeDao.findBynationalIdentity(employee.getNationalIdentity()); 					
					
					if (!existingEmployees.isEmpty() || !existingEmployees2.isEmpty() || !(employee.getPassword().equals(employee.getPasswordRepeat()))) {
						System.out.println("KAYIT OLUNAMAZ BİLGİLERİNİZ SİSTEMDE MEVCUT (E MAİL YA DA TC Kimlik ");
						return false;
					}
				}
				employee3.setBirthYear(employee.getBirthYear());
				employee3.setEMail(employee.getEMail());
				employee3.setFirstName(employee.getFirstName());
				employee3.setLastName(employee.getLastName());
				employee3.setNationalIdentity(employee.getNationalIdentity());
				employee3.setPassword(employee.getPassword());
				employee3.setPasswordRepeat(employee.getPasswordRepeat());
				mailService.postMail("E mail Hesabınıza Aktivasyon Linki Gönderildi");
				mailService.isCheckMail(true);
				employeeDao.save(employee3);
				return true;
			}
		}
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
