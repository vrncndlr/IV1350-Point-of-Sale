package main.se.kth.iv1350.pos.DTO;

import java.util.ArrayList;

import main.se.kth.iv1350.pos.model.Item;
import main.se.kth.iv1350.pos.model.Sale;

/**
 * A data transfer object containing information about the running total price, running total VAT of the <code>Sale</code>
 * and the last scanned <code>ItemDTO</code>, meant to be transferred to the <code>View</code>. 
 * 
 */
public class SaleStateDTO {

    private final ItemDTO scannedItemDTO;
    private final ArrayList<Item> listOfItems;
    private double runningTotal;
    private final double totalVAT;
    
    /**
     * Creates an instance of a <code>SaleStateDTO</code>
     * @param scannedItemDTO last scanned <code>ItemDTO</code>
     * @param rateOfVAT running total amound of VAT 
     * @param runningTotal running total price of the <code>Sale</code>.
     * @param listOfItems the current <code>Item</code> in the <code>checkOutCart</code>
     */
    public SaleStateDTO(ItemDTO scannedItemDTO, double totalVAT, double runningTotal, ArrayList<Item> listOfItems){
        this.runningTotal = runningTotal;
        this.totalVAT = totalVAT;
        this.scannedItemDTO = scannedItemDTO;
        this.listOfItems = listOfItems;
    }

    /**
     * Get the <code>scannedItemDTO</code>
     * @return scanned item
     */
    public ItemDTO getScannedItemDTO() {
        return scannedItemDTO;
    }
    /**
     * Get the running total of VAT of the <code>Sale</code>.
     * @return running total VAT 
     */
    public double getTotalVAT() {
        return totalVAT;
    }
    /**
     * Get the running total price of the <code>Sale</code>.
     * @return running total price 
     */
    public double getRunningTotal() {
        return runningTotal;
    }
    /**
     * Get the <code>listOfItems</code> in the current cart.
     * @return the current shopping list.
     */
     public final ArrayList<Item> getListOfItems() {
            return listOfItems;
    }

}