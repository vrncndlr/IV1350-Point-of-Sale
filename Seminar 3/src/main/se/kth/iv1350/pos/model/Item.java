package main.se.kth.iv1350.pos.model;

import main.se.kth.iv1350.pos.DTO.ItemDTO;

/**
 * Represents an item to be bought in the <code>Sale</code> and added to the checkout cart.
 *
 */
public class Item {

    private int itemID;
    private int quantity;
    private String name;
    private double price;
    private double rateOfVAT;

    /**
     * Creates an instance of an<code>Item</code>.
     * @param scannedItem  A complete <code>ItemDTO</code> with relevant information. 
     */
    public Item(ItemDTO scannedItem) {
        this.itemID = scannedItem.getItemID();
        this.quantity = scannedItem.getQuantity();
        this.name = scannedItem.getName();
        this.price = scannedItem.getPrice();
        this.rateOfVAT = scannedItem.getRateOfVAT();
    }
    /**
     * Set the new <code>quantity</code> of the <code>Item</code>.
     * @param quantity the new quantity of the item
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

     /**
     * Get the <code>identifier</code> of the <code>Item</code>.
     * @return identifier number of item
     */
    public int getItemID() {
        return itemID;
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
        return name;
    }

    /**
     * Get the <code>price</code> of the <code>Item</code>
     * @return Price of the item
     */
    public double getPrice() {
        return price;
    }

    /**
     * Get the VAT rate of the <code>Item</code>
     * @return the tax rate of the item
     */
    public double getRateOfVAT() {
        return rateOfVAT;
    }

}