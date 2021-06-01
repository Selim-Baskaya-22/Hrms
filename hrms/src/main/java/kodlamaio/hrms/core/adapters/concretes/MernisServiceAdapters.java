package kodlamaio.hrms.core.adapters.concretes;



import org.springframework.stereotype.Service;


import kodlamaio.hrms.core.adapters.abstracts.UserCheckService;
import kodlamaio.hrms.entities.concretes.Candidate;


@Service
public class MernisServiceAdapters implements UserCheckService<Candidate>{
	
	

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
				
			if (candidate.getNationalityId().length()!=11 || candidate.getFirstName().equals(null) || candidate.getLastName().length()<2 || candidate.getDateOfBirth().getYear()<1900) {
				return false;
			}
	 
			return true;
	}

	
}
