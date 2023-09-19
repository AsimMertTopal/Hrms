package Hrms.business.abstracts;

import java.util.List;

import Hrms.core.utilities.results.DataResult;
import Hrms.core.utilities.results.Result;
import Hrms.entities.concretes.WorkHistory;

public interface WorkHistoryService {
Result add(WorkHistory workHistory);
DataResult<List< WorkHistory>> findByOrderByLeavingJobYearDesc();
}
