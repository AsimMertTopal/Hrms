package Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	JobAdvertisement getByid(int id);
	 List<JobAdvertisement> findAll();
	 List<JobAdvertisement> findByjobAdvertisementStatusGreaterThan(int jobAdvertisementStatus);
	 List<JobAdvertisement> getByjobAdvertisementStatus(int jobAdvertisementStatus);
	 //List<JobAdvertisement> getByReleaseDateOrderByReleaseDateDesc();
	 List<JobAdvertisement> findByJobAdvertisementStatusGreaterThanOrderByReleaseDateDesc(int jobAdvertisementStatus);
	 List<JobAdvertisement> findByEmployerIdAndJobAdvertisementStatus(int employerId, int jobAdvertisementStatus);
}
	