package Hrms.business.abstracts;

import java.util.List;

import Hrms.core.utilities.results.DataResult;
import Hrms.core.utilities.results.Result;
import Hrms.entities.concretes.EducationInformation;

public interface EducationInformationService {
Result add(EducationInformation educationInformation);
DataResult<List<EducationInformation>>findByOrderByGraduationYearDesc();

}
