package Hrms.business.abstracts;

import java.util.List;

import Hrms.business.response.CvDetails;
import Hrms.core.utilities.results.DataResult;
import Hrms.core.utilities.results.Result;
import Hrms.entities.concretes.CvInformation;

public interface CvInformationService {
	Result add(CvInformation cvInformation);
	DataResult<List<CvDetails>> findAlll();
}
