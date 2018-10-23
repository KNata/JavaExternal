package SmartVechicles.CustomExeptions;

public class MyIndexOfBoundExeption extends RuntimeException {


    public MyIndexOfBoundExeption(String message) {
        super(message);
    }

    public MyIndexOfBoundExeption(String message, Throwable cause) {
        super(message, cause);
    }


}
