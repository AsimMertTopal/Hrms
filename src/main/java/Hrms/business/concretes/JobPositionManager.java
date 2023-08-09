package Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Hrms.business.abstracts.JobPositionService;
import Hrms.core.utilities.results.DataResult;
import Hrms.core.utilities.results.ErrorResult;
import Hrms.core.utilities.results.Result;
import Hrms.dataAccess.abstracts.JobPositionDao;
import Hrms.entities.concretes.JobPosition;
@Service
public class JobPositionManager implements JobPositionService {
  JobPositionDao jobPositionDao;
  
  @Autowired
  JobPositionManager(JobPositionDao jobPositionDao){
	  this.jobPositionDao=jobPositionDao;
			  
  }
  
  
	@Override
	public Result add(JobPosition jobPosition) {
		JobPosition jobPositionAdd =new JobPosition();
		 List <JobPosition>  jobNameList;
		 jobNameList =jobPositionDao.getByJobName(jobPosition.getJobName());
		 if(jobNameList.isEmpty()) {
			 jobPositionAdd.setJobName(jobPosition.getJobName());
			 jobPositionDao.save(jobPositionAdd);
			 return new Result(true, "İş Pozisyonu Eklendi");
		 } 
		
		return new ErrorResult("İş Pozisyonu Mevcut");
		
	}

	@Override
	public Result delete(JobPosition jobPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(JobPosition jobPosition) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public DataResult<List<JobPosition>> getByJobName(String jobName) {
		// TODO Auto-generated method stub
		return null;
	}

}
