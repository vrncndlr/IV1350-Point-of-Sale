package main.se.kth.iv1350.pos.integration;

// import main.se.kth.iv1350.pos.integration.AccountingHandler;
// import main.se.kth.iv1350.pos.integration.InventorySystem;
// import main.se.kth.iv1350.pos.integration.DiscountRegister;
// import main.se.kth.iv1350.pos.model.Item;
import main.se.kth.iv1350.pos.DTO.*;

/**
 * A representation of the class that controls and manages
 * the external databases.
 */
public class DBHandler {
    private AccountingHandler accountingSystem;
    private InventorySystem inventorySystem;
    private DiscountRegister discountRegister;

    /**
     * Creates a new instance of DBHandler.
     */
    public DBHandler(){
        this.accountingSystem = new AccountingHandler();
        this.inventorySystem = new InventorySystem();
        this.discountRegister = new DiscountRegister();
    }

    /**
    * Fetches <code>Item</code> with corresponding identifier.
    * @return The requested items DTO.
    * @param itemRequest The item that is being scanned.
    */
    public ItemDTO getItemDTO(int itemID) throws InvalidItemIdentifierException{
        ItemDTO itemInfo = inventorySystem.getItem(itemID); 
        return itemInfo; 
    }
    /**
     * Requests discount from discount database.
     * 
     * @param customerID ID of customer proving eligibility of discount..
     * @return An object of type discount dto.
     */

    public double discountRequest(String customerID){
        return discountRegister.getDiscount(customerID);
    }
    /**
     * This method updates the external databases after a succesful sale 
     * using their corresponding methods.
     * @param saleinformation The sale information.
     */
    public void updateExternalSystems(SaleStateDTO saleInfo){
        accountingSystem.updateAccountingSystem(saleInfo);
        inventorySystem.sendInventoryInfo(saleInfo);
    }
}
