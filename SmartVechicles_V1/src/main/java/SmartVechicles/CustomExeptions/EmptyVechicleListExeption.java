package SmartVechicles.CustomExeptions;

public class EmptyVechicleListExeption extends RuntimeException {


    public EmptyVechicleListExeption(String message) {
        super(message);
    }

    public EmptyVechicleListExeption(String message, Throwable cause) {
        super(message, cause);
    }


}
