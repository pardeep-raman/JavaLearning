package exceptionhandling.checkedexceptions;

public class CustomException extends Exception {

    CustomException(String message) {
        super(message);
    }

    CustomException(Throwable throwable) {
        super(throwable);
    }

    CustomException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
