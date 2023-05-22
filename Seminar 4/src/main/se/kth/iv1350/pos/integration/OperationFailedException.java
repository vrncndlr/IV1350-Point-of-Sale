package main.se.kth.iv1350.pos.integration;

/**
 * Checked exc??
 * Thrown when something went wrong, generic exception.
 */
public class OperationFailedException extends Exception {
    /**
     * Creates a new instance with the specified message and cause
     * @param msg Message containing information about the error
     * @param cause Cause of the exception
     */
    public OperationFailedException(String msg,
    Exception cause) {
    super(msg, cause);
    }
}
