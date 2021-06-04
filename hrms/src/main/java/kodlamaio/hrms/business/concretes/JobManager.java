package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.business.constants.ErrorMessages;
import kodlamaio.hrms.business.constants.SuccessMessages;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.Job;

@Service
public class JobManager implements JobService {

	private JobDao jobDao;

	@Autowired
	public JobManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}

	@Override
	public DataResult<List<Job>> getAll() {
		return new SuccessDataResult<List<Job>>(jobDao.findAll(), "Görevler Listelendi");
	}

	@Override
	public DataResult<Job> get(int id) {
		Optional<Job> job = this.jobDao.findById(id);
		if (!job.isPresent()) {
			return new ErrorDataResult<Job>(job.get(), ErrorMessages.couldntJobListed);
		}
		return new SuccessDataResult<Job>(job.get());
	}

	@Override
	public Result add(Job entity) {
		var result = BusinessRules.run(isEmpty(entity),jobExist(entity));
		if (result!=null) {
			return result;
		}
		this.jobDao.save(entity);
		return new SuccessResult(SuccessMessages.jobAdded);
	}

	@Override
	public Result delete(Job entity) {
		var result=BusinessRules.run(checkIfJobId(entity));
		if (result!=null) {
			return result;
		}
		this.jobDao.delete(entity);
		return new SuccessResult(SuccessMessages.jobDeleted);
	}

	@Override
	public Result update(Job job) {
		
		Optional<Job> jobs = this.jobDao.findById(job.getId());
		if (jobs.isPresent()) {

			Job jobUpdate = jobs.get();

			jobUpdate.setName(job.getName());
			jobDao.save(jobUpdate);

			return new SuccessResult(SuccessMessages.jobUpdated);
		}
		return new ErrorResult(ErrorMessages.couldntJobUpdated);
	}
	
	private Result isEmpty(Job job) {
		if (job.getName() == null ) {
			return new ErrorResult(ErrorMessages.userIsEmpty);
		}

		return new SuccessResult(true);

	}
	
	private Result jobExist(Job job) {
		var result=jobDao.getByName(job.getName());
		if (result!=null) {
			return new ErrorResult(ErrorMessages.jobExist);
		}
		return new SuccessResult(true);
	}
	
	private Result checkIfJobId(Job job) {
		if (job.getId() > 0) {
			this.jobDao.delete(job);
			return new SuccessResult(true);
		}
		return new ErrorResult(ErrorMessages.couldntJobDeleted);
	}

	@Override
	public DataResult<List<Job>> getAll(int pageNo, int pageSize) {
		Pageable pageable=PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<Job>>(this.jobDao.findAll(pageable).getContent(),SuccessMessages.jobListed);
	}

}
