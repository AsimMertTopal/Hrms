package Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Hrms.entities.concretes.EducationInformation;

public interface EducationInformationDao extends JpaRepository<EducationInformation, Integer>{
    List<EducationInformation> findByOrderByGraduationYearDesc();
	EducationInformation getById(int id);
}
