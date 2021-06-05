package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SkillDao;
import kodlamaio.hrms.entities.concretes.Skill;

@Service
public class SkillManager implements SkillService{

	private SkillDao skillDao;
	
	@Autowired
	public SkillManager(SkillDao skillDao) {
		super();
		this.skillDao = skillDao;
	}
	
	@Override
	public DataResult<List<Skill>> getAll() {
	return new SuccessDataResult<List<Skill>>(this.skillDao.findAll());
	}

	@Override
	public DataResult<Skill> get(int id) {
		Optional<Skill> skill= this.skillDao.findById(id);
		return new SuccessDataResult<Skill>(skill.get());
	}

	@Override
	public Result add(Skill entity) {
		this.skillDao.save(entity);
		return new SuccessResult(true);
	}

	@Override
	public Result delete(Skill entity) {
		this.skillDao.delete(entity);
		return new SuccessResult(true);
	}

	@Override
	public Result update(Skill entity) {
		// TODO Auto-generated method stub
		return null;
	}



}
