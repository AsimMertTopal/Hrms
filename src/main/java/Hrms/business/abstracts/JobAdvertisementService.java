package Hrms.business.abstracts;

import java.util.List;

import Hrms.business.response.AllActiveJobAdversiments;
import Hrms.core.utilities.results.DataResult;
import Hrms.core.utilities.results.Result;
import Hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	
	Result add(JobAdvertisement jobAdvetisiment);
	DataResult<List<AllActiveJobAdversiments>> findAlll();
		
}
