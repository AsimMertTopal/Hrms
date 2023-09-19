package Hrms.business.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllActiveJobAdversiments {
	String companyName;
    String jobPosition;
    int openPositionCount;
    Date releaseDate;
    Date applicationDeadline;
}
