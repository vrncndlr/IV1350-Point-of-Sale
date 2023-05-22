package main.se.kth.iv1350.pos.integration;

/**
 * Checked exception
 * Thrown if the identifier scanned is not found by the system.
 */
public class InvalidItemIdentifierException extends Exception{
    int id;
    /**
     * Creates a new instance of InvalidItemIdentifierException with a 
     * message specifying which itemID could not be found.
     * @param itemID The ID that could not be scanned
     */
    public InvalidItemIdentifierException(int itemID){
        super("The item with the ID " + itemID + "cannot be found");
        id = itemID;
    }

    public int getID(){
        return id;
    }
}
