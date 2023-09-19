package Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Hrms.entities.concretes.CvInformation;

public interface CvInformationDao extends JpaRepository<CvInformation, Integer>{
	List<CvInformation> findAll();
}
