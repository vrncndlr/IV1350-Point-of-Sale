package main.se.kth.iv1350.pos.integration;

import java.util.ArrayList;

import main.se.kth.iv1350.pos.DTO.ItemDTO;
import main.se.kth.iv1350.pos.DTO.SaleStateDTO;
import main.se.kth.iv1350.pos.model.Item;

/**
 * A placeholder class representing an external inventory database.
 * fakeItemList represents a fake list of items wich forms the layer
 * that inventoryHandler communicates with.
 */
public class InventorySystem {

private final int lengthOfFakeItemList = 6;
    private final ItemDTO[] fakeItemList = new ItemDTO[lengthOfFakeItemList]; 
    /**
     * Creates an instance of the <code>InventoryHandler</code>.
     */
    public InventorySystem() {
        // int itemID, int quantity, String name, double price, double rateOfVAT
        fakeItemList[0] = new ItemDTO(0, 0, null, 0.0, 0.0);
        fakeItemList[1] = new ItemDTO(1, 0, "Water bottle", 10.0, 0.06);
        fakeItemList[2] = new ItemDTO(2, 0, "Snus", 55.00, 0.25);
        fakeItemList[3] = new ItemDTO(3, 0, "Sun screen", 79.0, 0.06);
        fakeItemList[4] = new ItemDTO(4, 0, "Dagens Nyheter", 39.0, 0.12);
        fakeItemList[5] = new ItemDTO(5, 0, "Chocolate", 20.0, 0.12);
    }
        /**
        * Gets information about the scanned item from the external inventory system.
        * Method will handle if identification number, itemID ,is out of range.
        * @param itemRequest An <code>ItemDTO</code> with an identifier number that verifies the scanned item.
        * @return scannedItem An <code>ItemDTO</code> that contains all the stored information about the scanned item. 
        */     
	public ItemDTO createItemDTO(ItemDTO itemRequest) {
        int itemID = itemRequest.getItemID();
        ItemDTO scannedItem;
            if(itemID < 0 || itemID > 5)
                 return scannedItem = null;
            else
                 return scannedItem = new ItemDTO(itemID, itemRequest.getQuantity(), fakeItemList[itemID].getName(), fakeItemList[itemID].getPrice(), fakeItemList[itemID].getRateOfVAT());
    }

     /**
     * Placeholder for the call to log all inventory changes in the external inventory system.
     * @param saleState the finalized info about the <code>Sale</code>.
     */
    public void sendInventoryInfo(SaleStateDTO saleState) {
        ArrayList<Item> listOfItemsBought = saleState.getListOfItems();
    }

}