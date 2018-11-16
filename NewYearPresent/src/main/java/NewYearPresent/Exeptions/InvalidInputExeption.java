package NewYearPresent.Exeptions;

public class InvalidInputExeption extends RuntimeException {

    public InvalidInputExeption(String message) {
        super(message);
    }

    public InvalidInputExeption(String message, Throwable cause) {
        super(message, cause);
    }
}
