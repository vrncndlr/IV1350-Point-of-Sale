package main.se.kth.iv1350.pos.model;

import java.util.ArrayList;

import main.se.kth.iv1350.pos.DTO.ItemDTO;
import main.se.kth.iv1350.pos.DTO.SaleStateDTO;
import main.se.kth.iv1350.pos.integration.DiscountRegister;

/**
 * Contains information about the current state of the <code>Sale</code> in progress. 
 */
public class Sale {
    private SaleStateDTO saleState;
    private DiscountRegister discountRegister;
    private ShoppingCart shoppingCart;
    private double totalPrice;
    private double totalVAT;
    private double receivedPayment;
    private double discount;

    /**
     * Creates an instance of <code>Sale</code>
     * @param checkOutCart Checkoutcart contains the <code>Item</code> in the current <code>Sale</code>.
     * @param discountRegister Handles the available discounts.
     */
    public Sale(ShoppingCart shoppingCart, DiscountRegister discountRegister) {
        this.shoppingCart = shoppingCart;
        this.discountRegister = discountRegister;
        this.totalPrice = 0.0;
        this.receivedPayment = 0.0;
        this.discount = 0.0;
        this.totalVAT = 0.0;
    }

    /**
     * Updates the running total with the <code>price</code> and VAT of the latest scanned item.
     * @param scannedItem the latest scanned item
     * @return contains relevant info of states in the program.
     */
    public SaleStateDTO updateRunningTotal(ItemDTO scannedItem) {
            totalVAT = totalVAT + calculateVAT(scannedItem);
            this.totalPrice = this.totalPrice + scannedItem.getPrice() * scannedItem.getQuantity() + calculateVAT(scannedItem);

            saleState = updateSaleState(scannedItem, totalVAT, totalPrice);

        return saleState;
    }

    public void requestDiscount(int customerID){
        discountRegister.getDiscount(customerID);
    }

    /**
     * Collects data to save to a DTO for eventual transfer to View.
     * @param scannedItem The latest scanned item
     * @param totalVAT the current amount of VATin the <code>Sale</code>.
     * @param totalPrice the current running total in the <code>Sale</code>.
     * @return the latest changes to the application, to be returned to View.
     */
    private SaleStateDTO updateSaleState(ItemDTO scannedItem, double totalVAT, double totalPrice){
        final ArrayList<Item> shoppingList = shoppingCart.getListOfItems();
        saleState = new SaleStateDTO(scannedItem, totalVAT, totalPrice, shoppingList);

        return saleState;
    }

    /**
     * Calculates the VAT of the given item.
     * @param scannedItem The itemDTO containing all information about an item.
     * @return cost of VAT for the scanned item
     */
    private double calculateVAT(ItemDTO scannedItem){
        double calculatedVAT = scannedItem.getPrice() * scannedItem.getRateOfVAT() * scannedItem.getQuantity();
        return calculatedVAT;
    }

    /**
     * Get method for the total price of the sale
     * @return the running total
     */
    public double getTotalPrice(){
        return totalPrice;
    }

}