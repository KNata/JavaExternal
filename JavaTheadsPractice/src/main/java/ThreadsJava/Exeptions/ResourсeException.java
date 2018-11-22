package ThreadsJava.Exeptions;

public class ResourсeException extends RuntimeException {
    
	public ResourсeException(String message) {
        super(message);
    }
    public ResourсeException(Throwable cause) {
        super(cause);
    }
}