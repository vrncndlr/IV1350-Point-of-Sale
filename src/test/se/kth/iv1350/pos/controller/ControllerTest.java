package test.se.kth.iv1350.pos.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import main.se.kth.iv1350.pos.controller.Controller;
import main.se.kth.iv1350.pos.integration.AccountingHandler;
import main.se.kth.iv1350.pos.integration.DiscountRegister;
import main.se.kth.iv1350.pos.integration.InventorySystem;
import main.se.kth.iv1350.pos.integration.Register;
import main.se.kth.iv1350.pos.integration.SalesLog;
import main.se.kth.iv1350.pos.DTO.*;
import main.se.kth.iv1350.pos.model.ShoppingCart;
import main.se.kth.iv1350.pos.model.Item;
import main.se.kth.iv1350.pos.model.Sale;

public class ControllerTest {
    Controller contr;
    ShoppingCart checkOutCart;
    InventorySystem inventorySystem;
    DiscountRegister discountRegister;
    AccountingHandler accountingHandler;
    Register register;
    SalesLog salesLog;
    Sale sale;
    ItemDTO itemRequest;

    @BeforeEach
    public void setUp() {
        inventorySystem = new InventorySystem();
        discountRegister = new DiscountRegister();
        accountingHandler = new AccountingHandler();
        itemRequest = new ItemDTO(5, 1, null, 0, 0);
        salesLog = new SalesLog(accountingHandler, inventorySystem);
        contr = new Controller(salesLog, inventorySystem, discountRegister, accountingHandler, register);
        contr.startNewSale();
    }

    @AfterEach
    public void tearDown() {
        inventorySystem = null;
        discountRegister = null;
        accountingHandler = null;
        checkOutCart = null;
        register = null;
        salesLog = null;
        contr = null;
        itemRequest = null;
        itemRequest = null;
    }
    /**
     * Test of scanItem method, of class Controller.
     */
    @Test
    public void testIfRightItemReturned() {
        //ItemDTO testDTO = new ItemDTO(2, 0, "Snus", 55.00, 0.25);
        ItemDTO testDTO = new ItemDTO(5, 1, "Chocolate", 20.0, 0.12);
        String expectedValue = new Item(testDTO).getName();

        SaleStateDTO saleStateDTO = contr.scanItem(itemRequest);
        String actual = saleStateDTO.getListOfItems().get(0).getName();
        assertEquals(expectedValue, actual, "Fail ");
    }

     @Test
    public void testIfScanItemReturnsCorrectTotal() {
        double expectedValue = 2 * (22.4); 
        SaleStateDTO saleStateDTO = contr.scanItem(itemRequest);
        saleStateDTO = contr.scanItem(itemRequest);
        double actual = saleStateDTO.getRunningTotal();

        assertEquals(expectedValue, actual, "The returned total price is not as the expected");    
    }

    @Test
    public void testIfVATIsReturnedCorrectly() {
        double expectedValue = 2.4; 
        SaleStateDTO saleStateDTO = contr.scanItem(itemRequest);
        double actual = saleStateDTO.getTotalVAT();
        assertEquals(expectedValue, actual, "The returned total VAT is not the same as the expected");    
    }

}
