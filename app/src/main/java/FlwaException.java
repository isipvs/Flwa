
/** */
public class FlwaException extends RuntimeException {

    public FlwaException() {
    }

    public FlwaException(String message) {
        super(message);
    }

    public FlwaException(String message, Throwable cause) {
        super(message, cause);
    }

    public FlwaException(Throwable cause) {
        super(cause);
    }
}
