package SmartVechicles.CustomExeptions;

public class NoCurrentLanguageExeption extends Exception {

    public NoCurrentLanguageExeption(String message) {
        super(message);
        System.out.println(message);
    }

    public NoCurrentLanguageExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public void errorMessage() {
        System.out.println("No such language avaliable. Please enter 1-4 to choose preferable language of interface");
    }
}
