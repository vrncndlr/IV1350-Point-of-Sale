package main.se.kth.iv1350.pos.startup;

import main.se.kth.iv1350.pos.view.View;
import main.se.kth.iv1350.pos.controller.*;
import main.se.kth.iv1350.pos.integration.*;


/**
 * Start the entire application, contains the <code>Main</code> method used to start the application.
 * 
 */
public class Main {
    /**
     *  Method used to start the application.
     * @param args  The application does not take any command-line parameters
     */  
    public static void main(String [] args) {
        Register register = new Register();
        AccountingHandler accountingHandler = new AccountingHandler();
        InventorySystem inventorySystem = new InventorySystem();
        SalesLog salesLog = new SalesLog(accountingHandler, inventorySystem);
        DiscountRegister discountRegister = new DiscountRegister();
        Controller controller = new Controller(salesLog, inventorySystem, discountRegister, accountingHandler, register);
        View view = new View(controller);    
        view.sampleExecution();
    }
}
