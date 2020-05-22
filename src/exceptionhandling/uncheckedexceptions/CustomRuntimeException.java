package exceptionhandling.uncheckedexceptions;

public class CustomRuntimeException extends RuntimeException {

    CustomRuntimeException(String message) {
        super(message);
    }

    CustomRuntimeException(Throwable throwable) {
        super(throwable);
    }

    CustomRuntimeException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
