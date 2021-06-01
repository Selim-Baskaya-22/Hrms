package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.business.BusinessCrudService; 

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.core.utilities.results.Result;


public interface CandidateService extends BusinessCrudService<Candidate> {
	Result getByEmail(String email);

}
