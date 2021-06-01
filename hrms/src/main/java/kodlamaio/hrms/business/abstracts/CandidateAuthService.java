package kodlamaio.hrms.business.abstracts;

 
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;


public interface CandidateAuthService {
	Result register(Candidate entity);
	Result login(Candidate entity);
}
