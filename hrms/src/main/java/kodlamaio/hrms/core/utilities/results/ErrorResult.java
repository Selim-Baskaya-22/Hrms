package kodlamaio.hrms.core.utilities.results;

public class ErrorResult extends Result{

	public ErrorResult( String message) {
		super(false, message);
	}
	
	public ErrorResult(boolean success) {
		super(false);
	}

}
