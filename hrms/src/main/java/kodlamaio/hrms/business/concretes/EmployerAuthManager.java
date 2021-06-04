package kodlamaio.hrms.business.concretes;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerAuthService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.constants.ErrorMessages;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerAuthManager implements EmployerAuthService<Employer> {

	private EmployerService employerService;

	@Autowired
	public EmployerAuthManager(EmployerService employerService) {
		super();
		this.employerService = employerService;

	}

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	@Override
	public Result register(Employer employer) {
		var result = BusinessRules.run(ifEmailFormatCheckValid(employer.getEmail()), ifDomainEqualsMail(employer));
		if (result != null) {
			return result;
		}

		return employerService.add(employer);
	}

	@Override
	public Result login(Employer employer) {
		return new SuccessResult("Başarıyla giriş yapıldı");
	}

//	private Result userExists(Employer mail) {
//		var result= employerService.getByEmail(mail.getEmail());
//		if (result!=null) {
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

		return new ErrorResult(ErrorMessages.emailFormatError);
	}

	private Result ifDomainEqualsMail(Employer employer) {
		String mail = employer.getEmail();
		String domain = employer.getWebsite();
		for (int i = 0; i < mail.length(); i++) {

			if (mail.charAt(i) == '@') {
				mail = mail.substring(0, i);

				break;
			}
		}
		for (int i = 0; i < domain.length(); i++) {

			if (domain.charAt(i) == '.') {
				domain = domain.substring(0, i);

				break;
			}
		}
		if (domain.equals(mail)) {
			return new SuccessResult(true);
		}
		return new ErrorResult(ErrorMessages.domainMismatch);

	}
}
