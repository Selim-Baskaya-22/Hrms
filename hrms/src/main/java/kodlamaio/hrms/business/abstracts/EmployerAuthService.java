package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;

public interface EmployerAuthService<T> {
	Result register(T entity);
	Result login(T entity);
}
