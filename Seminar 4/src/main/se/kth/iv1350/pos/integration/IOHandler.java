package main.se.kth.iv1350.pos.integration;

import main.se.kth.iv1350.pos.DTO.SaleStateDTO;
import main.se.kth.iv1350.pos.model.Receipt;
import java.time.format.DateTimeFormatter;

public class IOHandler {
    SalesLog salesLog;
    public IOHandler(){
        salesLog = new SalesLog();
    }

    /**
     * Logs most recent sale to a sale history log
     */
    public void updateSaleLog(SaleStateDTO currentSale){
        this.salesLog.logSale(currentSale);
    }

    public String printReceipt(Receipt receipt){
        StringBuilder sb = new StringBuilder("Receipt\n");
        DateTimeFormatter dateAndTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        sb.append(receipt.getDateTime().format(dateAndTimeFormatter));
        sb.append(String.format("%n%n"));   
       
        sb.append(String.format("%-21s %3s %11s%n", "Item", "Qty", "Price"));
        sb.append(receipt.getListOfItems());
        sb.append(String.format("%n%n"));   

        sb.append("Total price: ");
        sb.append(receipt.getTotalPrice());
        sb.append(String.format("%n"));    
        sb.append("VAT: ");
        sb.append(receipt.getVATAmount());
        sb.append(String.format("%n"));    
        sb.append("Amount to pay: ");
        sb.append(receipt.getAmountToPay());
        sb.append(String.format("%n"));    

        sb.append("Payment: ");
        sb.append(receipt.getAmountPaid());
        sb.append(String.format("%n"));    
        sb.append("Change: ");
        sb.append(receipt.getChange());
        sb.append(String.format("%n"));    

        return sb.toString();
    }
}
