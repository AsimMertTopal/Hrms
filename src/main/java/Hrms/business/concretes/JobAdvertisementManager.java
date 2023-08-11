package Hrms.business.concretes;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Hrms.business.abstracts.JobAdvertisementService;
import Hrms.business.response.AllActiveJobAdversiments;
import Hrms.core.utilities.results.DataResult;
import Hrms.core.utilities.results.Result;
import Hrms.dataAccess.abstracts.JobAdvertisementDao;
import Hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
	JobAdvertisementDao advertisementDao;
	
	
	@Autowired
	public JobAdvertisementManager( JobAdvertisementDao advertisementDao) {
		this.advertisementDao=advertisementDao;
		
	}
	
	
	@Override
	public Result add(JobAdvertisement jobAdvetisiment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<AllActiveJobAdversiments>> findAlll() {
		
		List<AllActiveJobAdversiments> allActiveJobAdversiment;
		
		AllActiveJobAdversiments activeJobAdversiments = new AllActiveJobAdversiments();
		
		List<JobAdvertisement> jobAdversiment;
		
		jobAdversiment = advertisementDao.findAll();
		
		for(int i =0;i<jobAdversiment.size();i++) {
			System.out.println(i);
			System.out.println(jobAdversiment.get(i));
		}
		return null;
	}

}
