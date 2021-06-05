package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SchoolDao;
import kodlamaio.hrms.entities.concretes.School;

@Service
public class SchoolManager implements SchoolService{

	private SchoolDao schoolDao;
	
	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}
	@Override
	public DataResult<List<School>> getAll() {
		return new SuccessDataResult<List<School>>(this.schoolDao.findAll());
	}

	@Override
	public DataResult<School> get(int id) {
		Optional<School> school=this.schoolDao.findById(id);
		return new SuccessDataResult<School>(school.get());
	}

	@Override
	public Result add(School entity) {
		this.schoolDao.save(entity);
		return new SuccessResult(true);
	}

	@Override
	public Result delete(School entity) {
		this.schoolDao.delete(entity);
		return new SuccessResult(true);
	}

	@Override
	public Result update(School entity) {
		// TODO Auto-generated method stub
		return null;
	}



}
