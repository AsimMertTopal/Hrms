package Hrms.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="work_history")
public class WorkHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="workHistory_id")
	private int id;
	
	@Column(name="work_name")
	private String workName;
	
	@Column(name="working_position")
	private String workingPosition;
	
	@Column(name="job_start_year")
	
	private int jobStartYear;
	
	@Column(nullable=true,name="leaving_job_year")
	
	private int leavingJobYear;

}
