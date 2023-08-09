package Hrms.business.abstracts;

import java.util.List;

import Hrms.core.utilities.results.DataResult;
import Hrms.core.utilities.results.Result;
import Hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	Result add(JobPosition jobPosition);
	Result delete(JobPosition jobPosition);
	Result update(JobPosition jobPosition);

	DataResult <List<JobPosition>> getByJobName(String jobName); 
}
