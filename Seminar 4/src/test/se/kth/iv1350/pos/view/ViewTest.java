package test.se.kth.iv1350.pos.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import main.se.kth.iv1350.pos.view.View;
import main.se.kth.iv1350.pos.controller.Controller;
import main.se.kth.iv1350.pos.integration.*;
import main.se.kth.iv1350.pos.model.Register;

class ViewTest {
	private View instanceToTest;
	private ByteArrayOutputStream printoutBuffer;
	private PrintStream originalSysOut;
    SalesLog salesLog;
    InventorySystem inventorySystem;
    DiscountRegister discountRegister;
    AccountingHandler accountingHandler;
    Register register;

	@BeforeEach
	void setUp() throws Exception {
        inventorySystem = new InventorySystem();
        accountingHandler = new AccountingHandler();
        discountRegister = new DiscountRegister();
        register = new Register();
        salesLog = new SalesLog(accountingHandler, inventorySystem);
		Controller contr = new Controller(salesLog,inventorySystem,discountRegister,accountingHandler,register);
		instanceToTest = new View(contr);
		printoutBuffer = new ByteArrayOutputStream();
		PrintStream inMemSysout = new PrintStream(printoutBuffer);
		originalSysOut = System.out;
		System.setOut(inMemSysout);
	}

	@AfterEach
	void tearDown() throws Exception {
        inventorySystem = null;
        accountingHandler = null;
        discountRegister = null;
        register = null;
        salesLog = null;
		instanceToTest = null;
		printoutBuffer = null;
		System.setOut(originalSysOut); 
	}

	@Test
	void testSampleExecution() {
		instanceToTest.sampleExecution();
		String printOut = printoutBuffer.toString();
		assertTrue(printOut.contains("initialized"), "Sale did not start correctly.");
	}
}
