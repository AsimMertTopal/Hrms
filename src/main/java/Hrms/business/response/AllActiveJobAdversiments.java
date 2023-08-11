package Hrms.business.response;

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
    String releaseDate;
    String applicationDeadline;
}
