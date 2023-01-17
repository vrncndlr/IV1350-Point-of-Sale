package main.se.kth.iv1350.pos.view;
import java.util.Locale;
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
         System.out.println("View: new sale initialized");

         System.out.println("---------DISPLAY---------");
         toBePrinted = contr.scanItem(firstItem);
         ItemDTO item = toBePrinted.getScannedItemDTO();
         System.out.println("Scanning item");
         System.out.println("Last scanned item: " + item.getName());
         System.out.println("Price: " + item.getPrice());
         System.out.printf(Locale.US, "VAT: %.1f\n ", (item.getRateOfVAT())*item.getPrice() );
         System.out.println();
         toBePrinted = contr.scanItem(secondItem);
         item = toBePrinted.getScannedItemDTO();
         System.out.println("Scanning item");
         System.out.println("Last scanned item: " + toBePrinted.getScannedItemDTO().getName());
         System.out.println("Price: " + toBePrinted.getScannedItemDTO().getPrice());
         System.out.printf(Locale.US, "VAT: %.1f\n ", (item.getRateOfVAT())*item.getPrice() );
         System.out.println();
         toBePrinted = contr.scanItem(thirdItem);
         item = toBePrinted.getScannedItemDTO();
         System.out.println("Scanning item");
         System.out.println("Last scanned item: " + toBePrinted.getScannedItemDTO().getName());
         System.out.println("Price: " + toBePrinted.getScannedItemDTO().getPrice());
         System.out.printf(Locale.US, "VAT: %.1f\n ", (item.getRateOfVAT())*item.getPrice() );
         System.out.println();
         System.out.println("View: ending sale.");
         contr.requestDiscount(960620);
         receipt = contr.concludeSale(paymentReceived);
         receipt.printReceipt();
     }

}