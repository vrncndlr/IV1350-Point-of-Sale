package main.se.kth.iv1350.pos.controller;

import main.se.kth.iv1350.pos.DTO.PaymentInfoDTO;
import main.se.kth.iv1350.pos.DTO.ReceiptDTO;
import main.se.kth.iv1350.pos.DTO.SaleStateDTO;
import main.se.kth.iv1350.pos.DTO.ItemDTO;
import main.se.kth.iv1350.pos.integration.AccountingHandler;
import main.se.kth.iv1350.pos.integration.DiscountRegister;
import main.se.kth.iv1350.pos.integration.InventorySystem;
import main.se.kth.iv1350.pos.integration.Register;
import main.se.kth.iv1350.pos.integration.SalesLog;
import main.se.kth.iv1350.pos.model.Sale;
import main.se.kth.iv1350.pos.model.ShoppingCart;

/**
 * This is the controller of the program. All calls from the <code>Wiew</code> pass through this class.
 * 
 */
public class Controller {

    private InventorySystem inventorySystem;
    private DiscountRegister discountRegister;
    private AccountingHandler accountingHandler;
    private SalesLog salesLog;
    private Sale sale;
    private ReceiptDTO receiptDTO;
    private ShoppingCart shoppingCart;
    private Register register;

    /**
     * Creates an instance of a <code>Controller</code>.
     * 
     * @param salesLog the handler that logs completed sales. 
     * @param inventoryHandler the handler that connects to the inventory system.
     * @param discountRegister the handler that connects to a discount database. 
     * 
     */
    public Controller(SalesLog salesLog, InventorySystem inventorySystem, DiscountRegister discountRegister, AccountingHandler accountingHandler, Register register) {
        this.salesLog = salesLog;
        this.inventorySystem = inventorySystem;
        this.discountRegister = discountRegister;
        this.accountingHandler = accountingHandler;
        this.register = register;       
    }
    /**
     * Starts a new <code>Sale</code>.
     */
    public void startNewSale() {
        System.out.println("Controller: new sale initialized");
        shoppingCart = new ShoppingCart(inventorySystem);
        sale = new Sale(shoppingCart, discountRegister);    
    }
    
    /**
     * Based on the input <code>ItemDTO</code>, add a corresponding <code>Item</code>to the cart and update the running total.
     * @param itemRequest a proto-item, all values null except for <code>identifier</code>.
     * @return contains relevant info of states in the program.
     */
    public SaleStateDTO scanItem(ItemDTO itemRequest){
        System.out.println("Controller: scanning item");
        ItemDTO scannedItem = shoppingCart.addItem(itemRequest);
        SaleStateDTO saleStateDTO =  sale.updateRunningTotal(scannedItem);
        System.out.println("Last scanned item: " + scannedItem.getName());
        System.out.println("Price: " + scannedItem.getPrice());
        System.out.println("VAT: " + (scannedItem.calculateVAT()));
        System.out.println();
        return saleStateDTO;
    }

    public void requestDiscount(int customerID){
        sale.requestDiscount(customerID);
    }

    /**
     * Ends the <code>Sale</code> and make sure all logs are done.
     * @param paymentReceived received payment from customer
     * @return receipt with all information about the <code>Sale</code>
     */
    public ReceiptDTO concludeSale(double paymentReceived) {
        ItemDTO noItem = new ItemDTO(0, 0, null, 0, 0);
        SaleStateDTO saleStateDTO = sale.updateRunningTotal(noItem);

        PaymentInfoDTO paymentInfoDTO = register.calculateChange(saleStateDTO, paymentReceived);
        salesLog.logSale(saleStateDTO, paymentInfoDTO);

        ReceiptDTO receipt = new ReceiptDTO(saleStateDTO,paymentInfoDTO);
        System.out.println("Controller: ending sale.");

        return receipt;
    }


}