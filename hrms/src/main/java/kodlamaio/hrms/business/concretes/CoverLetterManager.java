package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CoverLetterDao;
import kodlamaio.hrms.entities.concretes.CoverLetter;

@Service
public class CoverLetterManager implements CoverLetterService{

	private CoverLetterDao coverLetterDao;
	
	@Autowired
	public CoverLetterManager(CoverLetterDao coverLetterDao) {
		super();
		this.coverLetterDao = coverLetterDao;
	}

	@Override
	public DataResult<List<CoverLetter>> getAll() {
		return new SuccessDataResult<List<CoverLetter>>(this.coverLetterDao.findAll());
	}

	@Override
	public DataResult<CoverLetter> get(int id) {
		
		Optional<CoverLetter> coverLetter=this.coverLetterDao.findById(id);
		return new SuccessDataResult<CoverLetter>(coverLetter.get());
	}

	@Override
	public Result add(CoverLetter entity) {
		this.coverLetterDao.save(entity);
		return new SuccessResult(true);
	}

	@Override
	public Result delete(CoverLetter entity) {
		this.coverLetterDao.delete(entity);
		return new SuccessResult(true);
	}

	@Override
	public Result update(CoverLetter entity) {
		// TODO Auto-generated method stub
		return null;
	}


}
