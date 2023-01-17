package main.se.kth.iv1350.pos.DTO;
/**
 * Represent an <code>Item</code> that can be bought in the sale.
 * 
 */
public class ItemDTO {
    private final int itemID;
    private final int quantity;
    private final String name;
    private final double price;
    private final double rateOfVAT;

    /**
    * Creates an instance of <code>ItemDTO</code>
    * @param itemID An unique number for each <code>ItemDTO</code>
    * @param quantity Amount of <code>ItemDTO</code> of the same type.
    * @param name The <code>ItemDTO</code> colloquial identifier.
    * @param price The cost of the <code>ItemDTO</code>.
    * @param rateOfVAT The VAT rate of the <code>ItemDTO</code> where 1 is 100%.
    */
    public ItemDTO (int itemID, int quantity, String name, double price, double rateOfVAT) {
        this.itemID = itemID;
        this.quantity = quantity;
        this.name = name;
        this.price = price;
        this.rateOfVAT = rateOfVAT;
    }
    
    /**
     * Get the <code>identifier</code> number of the  <code>ItemDTO</code>
     * @return identifier number of item
     */
    public int getItemID() {
        return itemID;
    }
    /**
     * Get the  <code>quantity</code> of the  <code>ItemDTO</code>
     * @return quantity of item
     */
    public int getQuantity() {
        return quantity;
    }
    /**
     * Get the <code>price</code> of the <code>ItemDTO</code>
     * @return price of item
     */
    public double getPrice() {
        return price;
    }

    /**
     * Get the <code>name</code> of the  <code>ItemDTO</code>
     * @return name of item
     */
    public String getName() {
        return name;
    }

    /**
     * Get the VAT rate of the  <code>ItemDTO</code>
     * @return VAT rate of item
     */
    public double getRateOfVAT() {
        return rateOfVAT;
    }

    /**
     * Calculate the amount that is the tax alone
     * @return A double representing the VAT of an item
     */
    public double calculateVAT(){
        return (price * rateOfVAT);
    }
    
}