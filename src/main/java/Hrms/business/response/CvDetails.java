package Hrms.business.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDetails {
	String firstName;
	String lastName;
	String nationalIdentity;
	String eMail;
	int birthYear;
	String schoolName;
	String department;
	int StartYear;
	int graduationYear;
	String workName;
	String workingPosition;
	int jobStartYear;
	int leavingJobYear;
	String languageName;
	int languageLevel;
	String aboutYourSelf;
	String programming;
    String linkedinUrl;
    String githubUrl;
}
