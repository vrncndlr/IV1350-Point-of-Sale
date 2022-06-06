package main.se.kth.iv1350.pos.view;

import main.se.kth.iv1350.pos.DTO.ItemDTO;
import main.se.kth.iv1350.pos.DTO.ReceiptDTO;
import main.se.kth.iv1350.pos.DTO.SaleStateDTO;
import main.se.kth.iv1350.pos.controller.Controller;
/**
 * This is a placeholder for the user interface. It contains a hardcoded execution with 
 * calls to all system operations in the <code>Controller</code>. 
 * 
 */
public class View {
    private Controller contr;
     /**
      * Creates an instance of a <code>View</code>.
      * @param controller the only access from the user interface to the business logic goes
      * through this controller.
      */
    public View(Controller contr) {
            this.contr = contr;

    }
     /**
      * hardcoded execution with calls to all system operations in the <code>Controller</code>.
      */
     public void sampleExecution(){
         ItemDTO firstItem = new ItemDTO(5, 1, null, 0, 0);
         ItemDTO secondItem = new ItemDTO(3, 1, null, 0, 0);
         ItemDTO thirdItem = new ItemDTO(2, 1, null, 0, 0);
         SaleStateDTO toBePrinted;

         ReceiptDTO receipt;
         double paymentReceived = 200;
         
         contr.startNewSale();

         System.out.println("---------DISPLAY---------");
         toBePrinted = contr.scanItem(firstItem);
         toBePrinted = contr.scanItem(secondItem);
         toBePrinted = contr.scanItem(thirdItem);

         contr.requestDiscount(960620);
         receipt = contr.concludeSale(paymentReceived);
         receipt.printReceipt();
     }

}