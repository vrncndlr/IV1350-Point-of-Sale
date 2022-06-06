// package main.se.kth.iv1350.pos.integration;

// import main.se.kth.iv1350.pos.integration.AccountingHandler;
// import main.se.kth.iv1350.pos.integration.InventorySystem;
// import main.se.kth.iv1350.pos.integration.DiscountRegister;
// import main.se.kth.iv1350.pos.DTO.*;

// /**
//  * A representation of the class that controls and manages
//  * the external databases.
//  */
// public class DBHandler {
//     private AccountingHandler accountingSystem;
//     private InventorySystem inventorySystem;
//     private DiscountRegister discountDatabase;

//     /**
//      * Creates a new instance of DBHandler.
//      */
//     public DBHandler(){
//         this.accountingSystem = new AccountingHandler();
//         this.inventorySystem = new InventorySystem();
//         this.discountDatabase = new DiscountRegister();
//     }

//     /**
//     * Fetches information for a particular item.
//     * @param itemRequest The item that is being scanned.
//     * @return The requested items DTO.
//     */
//     public ItemDTO createItemDTO(ItemDTO itemRequest){
//         ItemDTO itemInfoFound = inventorySystem.createItemDTO(itemRequest); 
//         return itemInfoFound; 
//     }

//      /**
//       * Fetches <code>Item</code> with corresponding identifier and quantity. 
//       *
//       * @param identifier The specified identifier.
//       * @param quantity  The specified quantity.
//       * @return The requested item. 
//       */
//     public Item getItem(ItemDTO itemRequest){
//         Item fetchItemFromDatabase = inventorySystem.getItem(identifier, quantity);
//         return fetchItemFromDatabase;
//     }

//     /**
//      * Requests discount from discount database.
//      * 
//      * @param customerID ID of customer proving eligibility of discount..
//      * @return An object of type discount dto.
//      */

//     public DiscountDTO discountRequest(int customerID){
//         return discountDatabase.discountRequest(customerID);
//     }
//     /**
//      * This method updates the external databases using their corresponding methods.
//      * 
//      * @param saleinformation The sale information.
//      */
//     public void updateExternalSystems (SaleDTO saleinformation){
//         accountingSystem.updateAccountingSystem(saleinformation);
//         inventorySystem.updateInventorySystem(saleinformation);
//     }

//     /**
//      * This method updates the inventory system using the inventorysystems corresponding method.
//      * 
//      * @param item The item to be added.
//      */
//     public void addItemToInventorySystem(Item item){
//         inventorySystem.addItemToInventorySystem(item);
//     }
// }
