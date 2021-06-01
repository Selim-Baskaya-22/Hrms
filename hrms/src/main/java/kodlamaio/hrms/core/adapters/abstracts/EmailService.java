package kodlamaio.hrms.core.adapters.abstracts;



public interface EmailService<T> {
	String sendEmail(T mail);
}
