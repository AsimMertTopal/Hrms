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
@Table(name="jobPosition")
public class JobPosition {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="jobPosition_id")
 private int id;
@Column(name="jobPosition_name")
 private String jobName;
 
}
