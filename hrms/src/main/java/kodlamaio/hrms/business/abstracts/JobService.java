package kodlamaio.hrms.business.abstracts;

   

import java.util.List;

import kodlamaio.hrms.core.business.BusinessCrudService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Job;

public interface JobService extends BusinessCrudService<Job>{
	DataResult<List<Job>> getAll(int pageNo,int pageSize);
	
}
