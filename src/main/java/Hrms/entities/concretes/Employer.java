package Hrms.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employer")
public class Employer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employer_id")
	private int id;
	
	@Column(name="employer_companyName")
	@NotBlank
	private String companyName;
	
	@Column(name="employer_webSite")
	@NotBlank
	private String webSite;
	
	@Column(name="employer_eMail")
	@NotBlank
	private String eMail;
	
	@Column(name="employer_telephoneNumber")
	@NotBlank
	@Size (min = 6)
	private String telephoneNumber;
	
	@Column(name="employer_password")
	@NotBlank
	@Size(min = 6)
	private String password;
	
	@Column(name="employer_passwordRepate")
	@NotBlank
	private String passwordRepate;
	
	@Column(name="employer_status")
	private int employerStatus;
	
	

}
