package kodlamaio.hrms.core.adapters.abstracts;




public interface UserCheckService<T> {
	boolean checkIfRealPerson(T entity);
}
