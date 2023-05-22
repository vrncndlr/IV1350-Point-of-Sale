package main.se.kth.iv1350.pos.integration;

/**
 * Unchecked exception
 * Thrown when the database cannot be called.
 */
public class DatabaseException extends RuntimeException{
    /**
     * Creates a new instance representing the condition described in the specified message.
     * @param msg A message that describes what went wrong.
     */
    public DatabaseException(String msg){
        super(msg);
    }
}
