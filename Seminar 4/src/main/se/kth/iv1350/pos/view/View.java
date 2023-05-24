package main.se.kth.iv1350.pos.view;

import java.io.IOException;
import java.time.LocalDateTime;

import main.se.kth.iv1350.pos.DTO.SaleStateDTO;
import main.se.kth.iv1350.pos.controller.Controller;
import main.se.kth.iv1350.pos.integration.OperationFailedException;
import main.se.kth.iv1350.pos.util.TotalRevenueFileOutput;
import main.se.kth.iv1350.pos.integration.InvalidItemIdentifierException;
import main.se.kth.iv1350.pos.util.Logger;

/**
 * This is a placeholder for the user interface. It contains a hardcoded execution with 
 * calls to all system operations in the <code>Controller</code>. 
 * 
 */
public class View {
    private Logger logger;
    private final Controller contr;
    private TotalRevenueFileOutput totalRevenueOutput;
    private TotalRevenueView totalRevenueView;
    
     /**
      * Creates an instance of a <code>View</code>.
      * @param controller the only access from the user interface to the business logic goes
      * through this controller.
      */
    public View(Controller contr){
        this.contr = contr;
        totalRevenueView = new TotalRevenueView();
        contr.addObserver(totalRevenueView);
        totalRevenueOutput = new TotalRevenueFileOutput() {};
        contr.addObserver(totalRevenueOutput);
        try {
            logger = new Logger();
        } catch (Exception e) {
            writeToDevsAndUsers("Failed to initialize the log handler", e);
        }
    }
    public void sampleStartSale(){
        contr.startNewSale();
        System.out.println("View: new sale initialized");
        System.out.println("---------DISPLAY---------");
    }
     /**
      * hardcoded execution with calls to all system operations in the <code>Controller</code>.
      */
     public void sampleExecution(int id) {
         try {
             SaleStateDTO toBePrinted = contr.scanItem(id);
             System.out.println("Scanned: " + toBePrinted.getListOfItems());
             System.out.println("Total: " + toBePrinted.getRunningTotal());
             System.out.println();
        } catch (InvalidItemIdentifierException iiie) {
            writeToDevsAndUsers("Cannot find any item with the ID", iiie);
        }
        catch (OperationFailedException ofe) {
            writeToDevsAndUsers("Something went wrong when scanning the item. Try again.", ofe);
            
        }
    }

    public void sampleEndSale(){
        SaleStateDTO toBePrinted = contr.concludeSale();
        System.out.println("View: ending sale.");
        System.out.println("-------RECEIPT---------");
        System.out.println("Date and time: " + LocalDateTime.now());
        System.out.println("Items bought: " + toBePrinted.getListOfItems());
        System.out.printf("Total excl. VAT: %.2f%n", toBePrinted.getRunningTotal());
        System.out.printf("VAT: %.2f%n", toBePrinted.getTotalVAT());
        contr.requestDiscount("960620");
        System.out.println("Total incl. VAT: " + toBePrinted.getAmountToPay());
        System.out.println("-----------------------");
        System.out.println();
    }

    public void sampleRegisterPayment(int payment){
        System.out.println("Received payment: " + payment);
        double change = contr.getChange(payment);
        System.out.println("Change back: " + change);
        System.out.println("---------NEXT CUSTOMER---------");
        System.out.println();
    }
    private void writeToDevsAndUsers (String msg, Exception exception) {
        logger.displayErrorMessage(msg);
        logger.logErrorMessage(exception);
    }
}