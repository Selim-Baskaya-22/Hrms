package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.constants.ErrorMessages;
import kodlamaio.hrms.business.constants.SuccessMessages;
import kodlamaio.hrms.core.adapters.abstracts.EmailService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private EmailService<Employer> emailService;
	@Autowired
	public EmployerManager(EmployerDao employerDao,EmailService<Employer> emailService) {
		super();
		this.employerDao = employerDao;
		this.emailService=emailService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(employerDao.findAll(), SuccessMessages.employerListed);
	}

	@Override
	public DataResult<Employer> get(int id) {
		Optional<Employer> employer = this.employerDao.findById(id);
		if (!employer.isPresent()) {
			return new ErrorDataResult<Employer>(employer.get(), ErrorMessages.couldntEmployerListed);
		}
		return new SuccessDataResult<Employer>(employer.get());
	}

	@Override
	public Result add(Employer entity) {
		var result = BusinessRules.run(isEmpty(entity),getByEmail(entity.getEmail()));
		if (result!=null) {
			return result;
		}
		emailService.sendEmail(entity);
		employerDao.save(entity);
		return new SuccessResult(SuccessMessages.employerAdded);
	}

	@Override
	public Result delete(Employer employer) {
		Optional<Employer> employers = this.employerDao.findById(employer.getId());
		if (employers.isPresent()) {
			this.employerDao.delete(employers.get());
			return new SuccessResult(SuccessMessages.employerDeleted);
		}
		return new ErrorResult(ErrorMessages.couldntEmployerDeleted);
	}

	@Override
	public Result update(Employer entity) {
		Optional<Employer> employer = this.employerDao.findById(entity.getId());
		if (employer.isPresent()) {

			Employer employerUpdate = employer.get();


			employerUpdate.setCompanyName(entity.getCompanyName());
			employerUpdate.setWebsite(entity.getWebsite());
			employerUpdate.setEmail(entity.getEmail());
			employerUpdate.setPassword(entity.getPassword());

			employerDao.save(employerUpdate);

			return new SuccessResult(SuccessMessages.employerUpdated);
		}
		return new ErrorResult(ErrorMessages.couldntEmployerUpdated);
	}

	
	
	
	
	
	
	
	
	private Result isEmpty(Employer employer) {
		if (employer.getCompanyName() == null || employer.getWebsite() == null || employer.getEmail() == null
				|| employer.getPassword() == null) {
			return new ErrorResult(ErrorMessages.userIsEmpty);
		}

		return new SuccessResult(true);

	}

	@Override
	public Result getByEmail(String email) {
		var result = this.employerDao.getByEmail(email);
		if (result == null) {

			return new SuccessResult(false);
		}
		return new ErrorResult(ErrorMessages.userExists);
	}

}
