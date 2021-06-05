package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkExperiencesDao;
import kodlamaio.hrms.entities.concretes.WorkExperience;

@Service
public class WorkExperienceManager implements WorkExperienceService{

	private WorkExperiencesDao workExperienceDao;
	
	@Autowired
	public WorkExperienceManager(WorkExperiencesDao workExperienceDao) {
		super();
		this.workExperienceDao = workExperienceDao;
	}
	
	@Override
	public DataResult<List<WorkExperience>> getAll() {
		return new SuccessDataResult<List<WorkExperience>>(this.workExperienceDao.findAll());
	}

	@Override
	public DataResult<WorkExperience> get(int id) {
		Optional<WorkExperience> workExperience=this.workExperienceDao.findById(id);
		return new SuccessDataResult<WorkExperience>(workExperience.get());
	}

	@Override
	public Result add(WorkExperience entity) {
		this.workExperienceDao.save(entity);
		return new SuccessResult(true);
	}

	@Override
	public Result delete(WorkExperience entity) {
		this.workExperienceDao.delete(entity);
		return new SuccessResult(true);
	}

	@Override
	public Result update(WorkExperience entity) {
		// TODO Auto-generated method stub
		return null;
	}



}
