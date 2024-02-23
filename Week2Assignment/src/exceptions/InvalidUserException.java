package exceptions;

public class InvalidUserException extends Exception {
    public InvalidUserException() {
        super("Invalid username or password");
    }

    public InvalidUserException(String message) {
        super(message);
    }
}