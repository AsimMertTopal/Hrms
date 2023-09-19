package Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Hrms.entities.concretes.WorkHistory;

public interface WorkHistoryDao extends JpaRepository<WorkHistory, Integer> {
	WorkHistory getById(int id);

	  List< WorkHistory> findByOrderByLeavingJobYearDesc();
}
