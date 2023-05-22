package main.se.kth.iv1350.pos.model;

import main.se.kth.iv1350.pos.DTO.ItemDTO;

/**
 * Represents an item to be bought in the <code>Sale</code> and added to the checkout cart.
 *
 */
public class Item {
    private int itemID;
    private String name;
    private int quantity;
    private double price;
    private double rateOfVAT;

    /**
     * Creates an instance of an<code>Item</code>.
     * @param scannedItem  A complete <code>ItemDTO</code> with relevant information. 
     */
    public Item(ItemDTO scannedItem) {
        this.itemID = scannedItem.getItemID();
        this.name = scannedItem.getName();
        this.quantity = scannedItem.getQuantity();
        this.price = scannedItem.getPrice();
        this.rateOfVAT = scannedItem.getRateOfVAT();
    }
    /**
     * Set the new <code>quantity</code> of the <code>Item</code>.
     * @param quantity the new quantity of the item
     */
    public void setQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }
    /**
     * In case you only need to increase to quiatity by one 
     * @return
     */
    public void increaseQuantity(){
        this.quantity ++;
    }

     /**
     * Get the <code>identifier</code> of the <code>Item</code>.
     * @return identifier number of item
     */
    public int getItemID() {
        return this.itemID;
    }

    /**
     * Get the <code>quantity</code> of the <code>Item</code>.
     * @return quantity of item
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Get the <code>name</code> of the <code>Item</code>
     * @return Name of the item
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the <code>price</code> of the <code>Item</code>
     * @return Price of the item
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Get the VAT rate of the <code>Item</code>
     * @return the tax rate of the item
     */
    public double getRateOfVAT() {
        return (this.price * this.quantity * this.rateOfVAT);
    }

}