package kodlamaio.hrms.core.adapters.concretes;

import java.util.Random;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.adapters.abstracts.EmailService;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateEmailServiceAdapters implements EmailService<Candidate>{
	Random a=new Random();
	@Override
	public String sendEmail(Candidate candidate) {
		int verificationCode=a.nextInt(1000)*10;
		return candidate.getEmail()+" adresine mail gönderildi.Mail kodu: "+verificationCode;
	}

}
