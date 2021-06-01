package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.business.BusinessCrudService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerService extends BusinessCrudService<Employer>{
	Result getByEmail(String email);
}
