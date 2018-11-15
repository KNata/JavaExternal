package NewYearPresent.Exeptions;

public class CandyNotFoundExeption extends RuntimeException {

        public CandyNotFoundExeption(String message) {
            super(message);
        }

        public CandyNotFoundExeption(String message, Throwable cause) {
            super(message, cause);
        }
}
