package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
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
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private EmailService<Candidate> emailService;
	@Autowired
	public CandidateManager(CandidateDao candidateDao, EmailService<Candidate> emailService) {
		super();
		this.candidateDao = candidateDao;
		this.emailService=emailService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(candidateDao.findAll(), SuccessMessages.candidateListed);
	}

	@Override
	public DataResult<Candidate> get(int id) {

		Optional<Candidate> candidate = this.candidateDao.findById(id);
		if (!candidate.isPresent()) {
			return new ErrorDataResult<Candidate>(candidate.get(), ErrorMessages.couldntCandidateListed);
		}
		return new SuccessDataResult<Candidate>(candidate.get());
	}

	@Override
	public Result add(Candidate entity) {
		var result = BusinessRules.run(isEmpty(entity),getByEmail(entity.getEmail()));
		if (result != null) {
			return result;
		}
		emailService.sendEmail(entity);
		candidateDao.save(entity);
		return new SuccessResult(SuccessMessages.candidateAdded);

	}

	@Override
	public Result delete(Candidate candidate) {
		Optional<Candidate> candidates = this.candidateDao.findById(candidate.getId());
		if (candidates.isPresent()) {
			this.candidateDao.delete(candidates.get());
			return new SuccessResult(SuccessMessages.candidateDeleted);
		}
		return new ErrorResult(ErrorMessages.couldntCandidateDeleted);
	}

	@Override
	public Result update(Candidate entity) {
		Optional<Candidate> candidate = this.candidateDao.findById(entity.getId());
		if (candidate.isPresent()) {

			Candidate candidateUpdate = candidate.get();

			candidateUpdate.setFirstName(entity.getFirstName());
			candidateUpdate.setLastName(entity.getLastName());
			candidateUpdate.setDateOfBirth(entity.getDateOfBirth());
			candidateUpdate.setNationalityId(entity.getNationalityId());
			candidateUpdate.setEmail(entity.getEmail());
			candidateUpdate.setPassword(entity.getPassword());

			candidateDao.save(candidateUpdate);

			return new SuccessResult(SuccessMessages.candidateUpdated);
		}
		return new ErrorResult(ErrorMessages.couldntCandidateUpdated);
	}

	private Result isEmpty(Candidate candidate) {
		if (candidate.getFirstName() == null || candidate.getLastName() == null 
				|| candidate.getNationalityId() == null || candidate.getEmail() == null
				|| candidate.getPassword() == null) {
			return new ErrorResult(ErrorMessages.userIsEmpty);
		}

		return new SuccessResult(true);

	}

	@Override
	public Result getByEmail(String email) {
		var result = this.candidateDao.getByEmail(email);
		if (result == null) {

			return new SuccessResult(false);
		}
		return new ErrorResult(ErrorMessages.userExists);
//		var result = candidateDao.findAll().stream().filter(e -> e.getEmail().equals(email)).findFirst().orElse(null);
//
//		if (result == null) {
//
//			return new SuccessResult(true);
//		}
//		return new ErrorResult(ErrorMessages.userExists);

	}

}
