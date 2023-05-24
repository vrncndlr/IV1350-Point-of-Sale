package main.se.kth.iv1350.pos.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import main.se.kth.iv1350.pos.integration.DBHandler;
import main.se.kth.iv1350.pos.integration.IOHandler;
import main.se.kth.iv1350.pos.DTO.SaleStateDTO;
import main.se.kth.iv1350.pos.DTO.ItemDTO;
import main.se.kth.iv1350.pos.model.Receipt;
import main.se.kth.iv1350.pos.model.Register;
import main.se.kth.iv1350.pos.model.Sale;
import main.se.kth.iv1350.pos.model.TotalRevenueObserver;
import main.se.kth.iv1350.pos.integration.InvalidItemIdentifierException;
import main.se.kth.iv1350.pos.integration.OperationFailedException;

/**
 * This is the controller of the program. All calls from the <code>View</code> pass through this class.
 */
public class Controller {
    private DBHandler dbHandler;
    private IOHandler ioHandler;
    private Sale sale;
    private Register register;
    private List<TotalRevenueObserver> revenueObservers = new ArrayList<>();

    /**
     * Creates an instance of a <code>Controller</code>.
     * @param dbHandler
     * @param ioHandler
     */
    public Controller(DBHandler dbHandler, IOHandler ioHandler) {
        this.dbHandler = dbHandler;
        this.ioHandler = ioHandler;
        this.register = new Register();
    }
    /**
     * Starts a new <code>Sale</code>.
     */
    public void startNewSale() {
        for(TotalRevenueObserver obs : revenueObservers)
            register.addObserver(obs);
        sale = new Sale();
        register.addObserver(null);  
    }
    
    /**
     * Based on the input <code>itemID</code>, add a corresponding <code>Item</code> to the sale.
     * @param itemID The ID of the item added to the current sale
     * @return Relevant info of the sale state
     * @throws InvalidItemIdentifierException if the ID does not exist in the database
     */
    public SaleStateDTO scanItem(int itemID) throws InvalidItemIdentifierException, OperationFailedException{
        try {
            ItemDTO scannedItem = dbHandler.getItemDTO(itemID);
            return this.sale.addItem(scannedItem);
        } catch (InvalidItemIdentifierException e) {
            throw new OperationFailedException("Could not scan the item.", e);
        }
    }

    /**
     * Gets discount
     * @param customerID
     */
    public void requestDiscount(String customerID){
        dbHandler.discountRequest(customerID);
    }

    /**
     * Ends the <code>Sale</code> and make sure everything is logged.
     * @return receipt with all information about the <code>Sale</code>
     */
    public SaleStateDTO concludeSale() {
        return this.sale.concludeSale();
    }

    /**
     * Get the change amount to give back to customer.
     * @param payment from customer
     */
    public double getChange(int payment){
        SaleStateDTO currentSale = sale.registerPayment(payment);
        Receipt receipt = new Receipt(currentSale);
        ioHandler.printReceipt(receipt);
        ioHandler.updateSaleLog(currentSale);
        dbHandler.updateExternalSystems(currentSale);
        this.sale.calculateChange();
        return sale.getChange();
    }

    /**
     * Calling the function to add a new total revenue observer to the register class
     * @param obs the revenue observer
     */
    public void addObserver(TotalRevenueObserver obs){
        register.addObserver(obs);
    }
}