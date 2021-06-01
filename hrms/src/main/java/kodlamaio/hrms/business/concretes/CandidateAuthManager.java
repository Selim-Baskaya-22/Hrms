package kodlamaio.hrms.business.concretes;

import java.util.regex.Pattern;   

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlamaio.hrms.business.abstracts.CandidateAuthService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.constants.ErrorMessages;
import kodlamaio.hrms.core.adapters.abstracts.EmailService;
import kodlamaio.hrms.core.adapters.abstracts.UserCheckService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateAuthManager implements CandidateAuthService {

	private CandidateService candidateService;
	private UserCheckService<Candidate> userCheckService;

	@Autowired
	public CandidateAuthManager(CandidateService candidateService,UserCheckService<Candidate> userCheckService) {
		super();
		this.candidateService = candidateService;
		this.userCheckService= userCheckService;

	}


	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	@Override
	public Result register(Candidate candidate) {

		var result = BusinessRules.run(ifEmailFormatCheckValid(candidate.getEmail()),checkRealPerson(candidate));
		if (result != null) {
			return result;
		}
		
		return candidateService.add(candidate);

	}

	@Override
	public Result login(Candidate candidate) {
	
		return new SuccessResult("Başarıyla giriş yapıldı");
	}

	
	
	
	
	
	
	
	private Result checkRealPerson(Candidate candidate) {

		var result =userCheckService.checkIfRealPerson(candidate);
		if (result==true) {
			return new SuccessResult(true);
		}
		return new ErrorResult(ErrorMessages.couldntAuthenticate);
	}
	
//	private Result userExists(String mail) {
//		var result= candidateService.getByEmail(mail);
//		if (result==null) {
//			return new ErrorResult(ErrorMessages.userExists);
//		}
//		return new SuccessResult(true);
//
//	}

	private Result ifEmailFormatCheckValid(String email) {
		var result = VALID_EMAIL_ADDRESS_REGEX.matcher(email).find();
		if (result == true) {
			return new SuccessResult(true);
		}

		return new ErrorResult(ErrorMessages.emailFormatError );
	}
	
	


}
