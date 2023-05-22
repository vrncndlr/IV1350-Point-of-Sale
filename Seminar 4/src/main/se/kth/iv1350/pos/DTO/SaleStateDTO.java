package main.se.kth.iv1350.pos.DTO;

import java.time.LocalDateTime;
/**
 * A data transfer object containing information about the running total price, running total VAT of the <code>Sale</code>
 * and the last scanned <code>ItemDTO</code>, meant to be transferred to the <code>View</code>. 
 * 
 */
public class SaleStateDTO {
    // private ArrayList<Item> listOfItems;
    private String listOfItems;
    private double runningTotal;
    private double totalVAT;
    private double toPay;
    private double paid;
    private double change;
    private LocalDateTime timeOfSale;
    
    /**
     * Creates an instance of a <code>SaleStateDTO</code>. Contains information of current sale
     * @param rateOfVAT running total amound of VAT 
     * @param runningTotal running total price of the <code>Sale</code>.
     * @param listOfItems the current <code>Item</code> in the <code>checkOutCart</code>
     */
    public SaleStateDTO(String listOfItems,
                        double runningTotal, 
                        double totalVAT, 
                        double toPay, 
                        double paid, 
                        double change, 
                        LocalDateTime timeOfSale){
        this.listOfItems = listOfItems;
        this.runningTotal = runningTotal;
        this.totalVAT = totalVAT;
        this.toPay = toPay;
        this.paid = paid;
        this.change = change;
        this.timeOfSale = timeOfSale;
    }

    /**
     * Get the <code>listOfItems</code> in the current cart.
     * @return the current shopping list.
     */
    public String getListOfItems() {
        return this.listOfItems;
    }
    /**
     * Get the running total price of the <code>Sale</code>.
     * @return running total price 
     */
    public double getRunningTotal() {
        return this.runningTotal;
    }
    /**
     * Get the running total of VAT of the <code>Sale</code>.
     * @return running total VAT 
     */
    public double getTotalVAT() {
        return this.totalVAT;
    }
    /**
     * Get the resulting amount to pay after VAT additiona and discounts.
     * @return double toPay
     */
    public double getAmountToPay(){
        return this.toPay;
    }
    /**
     * Get the amount paid for the sale
     * @return double paid
     */
    public double getAmountPaid(){
        return this.paid;
    }
    /**
     * Get the change given to the customer after their payment
     * @return double change
     */
    public double getChangeForPayment(){
        return this.change;
    }
    /**
     * Get the time and date of the sale.
     * @return LocalDateTime.
     */
    public LocalDateTime getTimeOfSale(){
        return this.timeOfSale;
    }

}