package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LanguageDao;
import kodlamaio.hrms.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {

	private LanguageDao languageDao;

	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}

	@Override
	public DataResult<List<Language>> getAll() {
		return new SuccessDataResult<List<Language>>(this.languageDao.findAll());
	}

	@Override
	public DataResult<Language> get(int id) {
		Optional<Language> language=this.languageDao.findById(id);
		return new SuccessDataResult<Language>(language.get());
	}

	@Override
	public Result add(Language entity) {
		this.languageDao.save(entity);
		return new SuccessResult(true); 
	}

	@Override
	public Result delete(Language entity) {
		this.languageDao.delete(entity);
		return new SuccessResult(true);
	}

	@Override
	public Result update(Language entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
