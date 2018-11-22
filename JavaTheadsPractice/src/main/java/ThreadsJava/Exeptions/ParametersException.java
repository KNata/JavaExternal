package ThreadsJava.Exeptions;

public class ParametersException extends RuntimeException {
	
	ParametersException() { }

	    public ParametersException(String message) {
	        super(message);
	    }

	    public ParametersException(String message, Throwable cause) {
	        super(message, cause);
	    }
}
