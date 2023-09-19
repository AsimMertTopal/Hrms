package Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Hrms.business.abstracts.WorkHistoryService;
import Hrms.core.utilities.results.DataResult;
import Hrms.core.utilities.results.Result;
import Hrms.core.utilities.results.SuccessDataResult;
import Hrms.core.utilities.results.SuccessResult;
import Hrms.dataAccess.abstracts.WorkHistoryDao;
import Hrms.entities.concretes.WorkHistory;

@Service
public class WorkHistoryManager implements WorkHistoryService{
	
	
 WorkHistoryDao workHistoryDao;
 
    @Autowired
	public WorkHistoryManager(WorkHistoryDao workHistoryDao) {
	this.workHistoryDao = workHistoryDao;
}

	@Override
	public Result add(WorkHistory workHistory) {
		WorkHistory workHistoryadd=new WorkHistory();
		workHistoryadd.setWorkingPosition(workHistory.getWorkingPosition());
		workHistoryadd.setJobStartYear(workHistory.getJobStartYear());
		workHistoryadd.setLeavingJobYear(workHistory.getLeavingJobYear());
		workHistoryDao.save(workHistory);
		return new SuccessResult("İş Tecrübesi Girildi");
	}

	@Override
	public DataResult<List<WorkHistory>> findByOrderByLeavingJobYearDesc() {
		List<WorkHistory> workHistoryList=workHistoryDao.findByOrderByLeavingJobYearDesc();
		workHistoryList.forEach(workHistoryGet ->{
			if(workHistoryGet.getLeavingJobYear()==-1) {
				workHistoryGet.setWorkName("Bu iş Yerinde Devam Ediyor");
				
			}
		});
		return new SuccessDataResult<List<WorkHistory>>(this.workHistoryDao.findByOrderByLeavingJobYearDesc(), "Geçmiş İş yılları Yakından Uzağa doğru sıralanmıştır.");
	}

}
