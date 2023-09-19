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
@Table(name="education_information")
public class EducationInformation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="education_id")
	private int id;
	
	@Column(name="school_name")
	private String schoolName;
	
	@Column(name="department")
	private String department;
	
	@Column(name="school_start_year")
	
	private int startYear;
	
	@Column(nullable=true,name="graduation_year")
	
	private int graduationYear;
	

}
