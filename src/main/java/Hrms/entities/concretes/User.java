package Hrms.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Table(name="users")
@Entity

public class User {
	@Id
	@GeneratedValue
	
	@Column(name="user_id")
 private int id;
	@Column (name="user_eMail")
 private String eMail;
	@Column (name="user_password")
 private String password;
	
	
	public User(int id, String eMail, String password) {
		super();
		this.id = id;
		this.eMail = eMail;
		this.password = password;
	}


	 
	
	

}
