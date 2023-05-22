package main.se.kth.iv1350.pos.DTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

import main.se.kth.iv1350.pos.model.Item;
/**
 * All final info regarding the proof of concluded <code>Sale</code>.
 */
public class ReceiptDTO {
	private final LocalDateTime timeForSale;
    private final String listOfBoughtItems;
    private final double totalPrice;
    private final double totalVAT;
    private final double receivedPayment;
    private final double change;
    private final double discount;


    /**
     * Creates an instance of a <code>ReceiptDTO</code>
     * @param saleStateDTO final state of the <code>Sale</code>, ready to be concluded. 
     * @param paymentInfoDTO contain total price and the exchange of cash for the concluded <code>Sale</code>.
     */
	public ReceiptDTO(SaleStateDTO saleStateDTO,PaymentInfoDTO paymentInfoDTO) {
            this.timeForSale = LocalDateTime.now();
            this.listOfBoughtItems = saleStateDTO.getListOfItems();
            this.totalPrice = saleStateDTO.getRunningTotal();
            this.totalVAT = saleStateDTO.getTotalVAT();
            this.receivedPayment = paymentInfoDTO.getPaymentReceived();
            this.change = paymentInfoDTO.getChange();
            this.discount = 0;
	}

    public void printReceipt(){
        System.out.println("---------RECEIPT---------");
         System.out.println("Time for sale: " + timeForSale);
         System.out.println("Total price: " + totalPrice);
         System.out.println("Discount: " + discount);
         System.out.println("Received Payment: " + receivedPayment);
         System.out.println("Change: " + change);
    }

    /**
    * Get the <code>change</code> in the concluded <code>Sale</code>.
    * @return amount of change
    */
    public double getChange() {
        return change;
    }

    /**
     * Get the total amount of discount in the concluded <code>Sale</code>
     * @return amound of discount
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * Get a list containing all items in the concluded <code>Sale</code>.
     * @return list containing all items in the sale
     */
    public String getListOfBoughtItems() {
        return listOfBoughtItems;
    }

    /**
     * Get the amount of received payment from customer in the concluded <code>Sale</code>
     * @return amount of received payment
     */
    public double getReceivedPayment() {
        return receivedPayment;
    }

    /**
     * Get the date and time for the concluded <code>Sale</code>
     * @return date and time
     */
    public LocalDateTime getTimeForSale() {
        return timeForSale;
    }

    /**
     * Get the total cost of concluded <code>Sale</code>
     * @return total cost
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Get the total amount of VAT for concluded <code>Sale</code>.
     * @return total amount of VAT.
     */
    public double getTotalVAT() {
        return totalVAT;
    }

}