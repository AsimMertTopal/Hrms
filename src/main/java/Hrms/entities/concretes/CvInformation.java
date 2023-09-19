package Hrms.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cv_information")
public class CvInformation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cv_information_id")
	private int id;
	
	@Column(name="language_name")
	private String languageName;
	
	@Column(name="language_level")
	@Size(max=5)
	private int languageLevel;
	
	@Column(name="about_yourself")
	private String aboutYourSelf;
	
	@Column(name="programming")
	private String programming;
	
	@Column(name="linkedin_URL")
	private String linkedinUrl;
	
	@Column(name="github_URL")
	private String githubUrl;
	

	@Column(name="workHistory_id")
	private int workHistoryId;
	
	@Column(name="education_id")
	private int educationInformationId;
	
	@Column (name="employee_id")	
	private int employeeId;

	

}
