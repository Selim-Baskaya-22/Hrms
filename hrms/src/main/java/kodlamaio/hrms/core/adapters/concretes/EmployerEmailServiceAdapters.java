package kodlamaio.hrms.core.adapters.concretes;

import java.util.Random;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.adapters.abstracts.EmailService;

import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerEmailServiceAdapters implements EmailService<Employer> {
	Random a=new Random();
	@Override
	public String sendEmail(Employer employer) {
		int verificationCode=a.nextInt(1000)*10;
		return employer.getEmail()+" adresine mail gönderildi.Mail kodu: "+verificationCode;
	}
}
