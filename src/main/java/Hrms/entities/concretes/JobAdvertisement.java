package Hrms.entities.concretes;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="JobAdvertisement")
public class JobAdvertisement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="jobAdvertisement_id")
	private int id;
	
	@Column(name="jobAdvertisement_name")
	@NotBlank
	private String name;
	
	@Column(name="jobAdvertisement_jobDescription")
	@NotBlank
	private String jobDescription;
			
	@Column(name="jobAdvertisement_wage")
	private double wage;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	@Column(name="jobAdvertisement_releaseDate")
	private Date releaseDate;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	@Column(name="jobAdvertisement_applicationDeadline")
	private Date applicationDeadline;
	
	@Column(name="jobAdvertisement_openPositionCount")
	@NotBlank
	private int openPositionCount;
	
	@Column(name="jobAdvertisement_jobAdvertisementStatus")
	private int jobAdvertisementStatus;
	
	
	@Column(name="employer_id")
	private int  employerId;
	

	@Column(name="jobPosition_id")
	private int jobPositionId;
	
	

}
