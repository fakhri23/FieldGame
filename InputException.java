package edu.kit.informatik;

/**
 * Exception for errors due to wrong or illegal input
 *
 * @author Fakhreddine Milouchi
 * @version 1.0
 */
public class InputException extends IllegalArgumentException {

    /**
     * construct an exception
     *
     * @param message error message
     */
    public InputException(String message) {
        super(message);
    }

    /**
     * construct an exception with default error message
     */
    public InputException() {
        super("Illegal Input.");
    }
}
