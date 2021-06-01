package kodlamaio.hrms.core.business;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

public interface BusinessCrudService<T> {
	
	DataResult<List<T>> getAll();
	DataResult<T> get(int id);
	Result add(T entity);
	Result delete(T entity);
	Result update(T entity);
}
