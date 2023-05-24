package main.se.kth.iv1350.pos.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import main.se.kth.iv1350.pos.DTO.ItemDTO;
import main.se.kth.iv1350.pos.DTO.SaleStateDTO;
import main.se.kth.iv1350.pos.integration.DBHandler;

/**
 * Contains information about the current state of the <code>Sale</code> in progress. 
 * 
 */
public class Sale {
    // private SaleStateDTO saleState;
    private DBHandler db;
    private List<TotalRevenueObserver> observers = new ArrayList<TotalRevenueObserver>();     
    private ArrayList<Item> shoppingCart;
    private double runningTotal;
    private double totalVAT;
    private double amountToPay;
    private double receivedPayment;
    private double change;
    private LocalDateTime timeOfSale;

    /**
     * Creates an instance of <code>Sale</code>
     */
    public Sale() {
        this.shoppingCart = new ArrayList<Item>();
        this.runningTotal = 0.0;
    }

    /**
     * Checks if the scanned <code>Item</code> exists, and if so, adds the item to the cart.
     * Utilizes built in methods get(), size() for <code>List</code> data structure
     * @param ItemDTO The item to scan
     * @return current SaleStateDTO
     */
    public SaleStateDTO addItem(ItemDTO itemRequest){
        int iaic = itemAlreadyInCart(itemRequest);
        if (iaic > -1){
            this.shoppingCart.get(iaic).increaseQuantity();
        } else {
            this.shoppingCart.add(new Item(itemRequest));
            int lastElement = 0;
            for(int i = 0; i<this.shoppingCart.size(); i++){
                lastElement = i;
            }
            this.shoppingCart.get(lastElement).setQuantity(1);
        }
        this.updateTotal();
        return new SaleStateDTO(
                                                shoppingListToString(),
                                                this.runningTotal, 
                                                this.totalVAT, 
                                                this.amountToPay, 
                                                this.receivedPayment, 
                                                this.change, 
                                                this.timeOfSale);
        // return saleState;
    }
    /**
     * Calculate change to get back after payment
     */
    public void calculateChange(){
        this.change = this.receivedPayment - this.amountToPay;
    }

    /**
     * Get method for the change
     * @return change amount
     */
    public double getChange(){
        return this.change;
    }

    /**
     * Check discount eligibility and apply if possible
     * @param customerID customers ID to check
     */
    public double getTotalDiscount(String customerID){
        return db.discountRequest(customerID);
    }

    /**
     * Conclude the surrent sale
     * @return all information about the current sale
     */
    public SaleStateDTO concludeSale(){
        updateTotal();
        // calculateChange();
        return new SaleStateDTO(shoppingListToString(),
                                this.runningTotal, 
                                this.totalVAT, 
                                this.amountToPay, 
                                this.receivedPayment, 
                                this.change, 
                                this.timeOfSale);
    }

    /**
     * Registers customers payment, calculate change to give back.
     * @param amount Amount paid by the customer.
     * @return Information about the sale.
     */
    public SaleStateDTO registerPayment(int amount) {
        updateTotal();
        this.receivedPayment = amount;
        calculateChange();
        this.notifyObservers();
        this.timeOfSale = java.time.LocalDateTime.now();
        return new SaleStateDTO(shoppingListToString(),
                                this.runningTotal,
                                this.totalVAT, 
                                this.amountToPay,
                                this.receivedPayment, 
                                this.change,
                                this.timeOfSale);
    }

    /**
     * Private methods for <code>Sale</code>
     */
    private String shoppingListToString() {
        StringBuilder sb = new StringBuilder();
        for (Item item : this.shoppingCart) {
            sb.append(String.format("%5s", item.getName()));
            // sb.append(String.format("%5s", item.getPrice()));
            sb.append(String.format("%5s", item.getQuantity()));
            sb.append(String.format("%12.2f\n", item.getPrice()));
        }
        return sb.toString();
    }
    private void updateTotal(){
        double VATsum = 0.0;
        double bruttoSum = 0.0;
        for(Item item : this.shoppingCart){
            bruttoSum += item.getPrice() * item.getQuantity();
            VATsum += item.getRateOfVAT() * item.getQuantity();
        }
        this.totalVAT = VATsum;
        this.runningTotal = bruttoSum;
        this.amountToPay = VATsum + bruttoSum;
    }
    private int itemAlreadyInCart(ItemDTO itemInformation) {
        for (int i = 0; i < this.shoppingCart.size(); i++) {
            if (this.shoppingCart.get(i).getItemID() == itemInformation.getItemID()) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Notifies observers about change of some state.
     * @param newBalance
     */
    private void notifyObservers() {
        for (TotalRevenueObserver obs : this.observers)
                obs.logRevenue(this.amountToPay);
        }

    /**
     * Adds an total revenue observer to an array list in the class Register
     * @param obs the total revenue observer in question
     */
    public void addObserver(TotalRevenueObserver obs){
            observers.add(obs);
    }
}
