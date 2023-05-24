package main.se.kth.iv1350.pos.model;

import java.time.LocalDateTime;
import main.se.kth.iv1350.pos.DTO.SaleStateDTO;

public class Receipt {
    private LocalDateTime dateAndTime;
    private String items;
    private double totalPrice;
    private double vatAmount;
    private double amountToPay;
    private double amountPaid;
    private double change;
    
    public Receipt(SaleStateDTO saleInfo){
        this.dateAndTime = saleInfo.getTimeOfSale();
        this.items = saleInfo.getListOfItems();
        this.totalPrice = saleInfo.getRunningTotal();
        this.vatAmount = saleInfo.getTotalVAT();
        this.amountToPay = saleInfo.getAmountToPay();
        this.amountPaid = saleInfo.getAmountPaid();
        this.change = saleInfo.getChangeForPayment();
    }

    /**
     * Get methods for Receipt
     * @return date and time of sale
     *         items bought
     *         price of sale excl. VAT
     *         total VAT amount
     *         total amount to pay
     *         amount paid by customer
     *         change to give back
     */
    public LocalDateTime getDateTime(){
        return this.dateAndTime;
    }
    public String getListOfItems(){
        return this.items;
    }
    public double getTotalPrice(){
        return this.totalPrice;
    }
    public double getVATAmount(){
        return this.vatAmount;
    }
    public double getAmountToPay(){
        return this.amountToPay;
    }
    public double getAmountPaid(){
        return this.amountPaid;
    }
    public double getChange(){
        return this.change;
    }
}
