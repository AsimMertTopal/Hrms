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
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="employee_id")	
	private int id;
	
	@Column (name="employee_name")
	@NotBlank
	private	String firstName;
	
	@Column (name="employee_lastName")
	@NotBlank
    private String lastName;
	
	@Column (name="employee_nationalIdentity")
	@NotBlank
    private String nationalIdentity;
	
	
	@Column (name="employee_eMail")
	@NotBlank
    private String eMail;
	
	@Column (name="employee_password")
	@NotBlank
    @Size(min = 6, max = 100)
    private String password;
	
	@Column (name="employee_passwordRepate")
	@NotBlank
    @Size(min = 6, max = 100)
    private String passwordRepeat;
	
	@Column (name="employee_birthYear")
	private int birthYear;
	

	
	}


