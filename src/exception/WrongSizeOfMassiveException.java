package exception;

public class WrongSizeOfMassiveException extends RuntimeException{
    public WrongSizeOfMassiveException() {
    }

    public WrongSizeOfMassiveException(String message) {
        super(message);
    }

    public WrongSizeOfMassiveException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongSizeOfMassiveException(Throwable cause) {
        super(cause);
    }

    public WrongSizeOfMassiveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
