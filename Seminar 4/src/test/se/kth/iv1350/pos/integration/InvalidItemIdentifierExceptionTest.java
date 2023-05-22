package test.se.kth.iv1350.pos.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import main.se.kth.iv1350.pos.DTO.ItemDTO;
import main.se.kth.iv1350.pos.integration.DatabaseException;
import main.se.kth.iv1350.pos.integration.InvalidItemIdentifierException;
import main.se.kth.iv1350.pos.integration.InventorySystem;


public class InvalidItemIdentifierExceptionTest {
    InventorySystem inventorySystem;
    
    @BeforeEach
    public void setUp() {
        inventorySystem = new InventorySystem();
    }

    @AfterEach
    public void tearDown() {
        inventorySystem = null;
    }

    @Test
    public void testRequestItemInfoSuccess() {
        try {
            ItemDTO result = inventorySystem.getItem(1);
            
            assertTrue(result.getName().equals("Banana"), "Name of item is not correct");
            assertEquals(2.5, result.getPrice(), "Price of item is not correct");
            assertEquals(1, result.getQuantity(), "Quantity of item is not correct");
            assertEquals(0.06, result.getRateOfVAT(), "VAT rate of item is not correct");
        }
        catch (Exception e) {
            fail("Retrieving existing item with ID: 1 failed with error: " + e.getMessage());
        }
    }

    @Test
    public void testRequestItemInfoNonExistentId() {
        try {
            ItemDTO result = inventorySystem.getItem(1010);
            fail("Could successfully retrieve non-existing item with ID: 1010");
        }
        catch (InvalidItemIdentifierException iiie) {
            assertTrue(iiie.getMessage().contains("1010"), "Wrong exception message, does not" +
                        "contain correct item ID number");
            assertEquals(1010, iiie.getID(), "Wrong exception ID number: " + iiie.getID());
        }
        catch (DatabaseException dbe) {
            fail("Wrong exception: " + dbe.getMessage());
        }
    }

    @Test
    public void testRequestItemInfoNegativeId() {
        try {
            ItemDTO result = inventorySystem.getItem(-2);
            fail("Could successfully retrieve non-existing item with ID: 1010");
        }
        catch (InvalidItemIdentifierException iiie) {
            assertTrue(iiie.getMessage().contains("-2"), "Wrong exception message, does not" +
                        "contain correct item ID number");
            assertEquals(-2, iiie.getID(), "Wrong exception ID number: " + iiie.getID());
        }
        catch (DatabaseException dbe) {
            fail("Wrong exception: " + dbe.getMessage());
        }
    }

    @Test
    public void testRequestItemInfoForceInventorySystemException() {
        try {
            ItemDTO result = inventorySystem.getItem(66);
            fail("Could not simulate database error");
        }
        catch (DatabaseException dbe) {
            assertTrue(dbe.getMessage().contains("database error"), "Wrong exception message: " + dbe.getMessage());
        }
        catch (Exception e) {
            fail("Wrong exception: " + e.getMessage());
        }
    }
}


// public class InvalidItemIdentifierExceptionTest {
//     private InventorySystem inventorySystem;
//     private ItemDTO item;

//     @BeforeEach
//     public void setUp() {
//         inventorySystem = new InventorySystem();
//         item = new ItemDTO(6, quantity, name, price, rateOfVAT)
//     }

//     @AfterEach
//     public void tearDown() {
//         inventorySystem = null;
//     }

//     /**
//      * Test of updateRunningTotal method, of class Sale. Tests if a valid SaleStateDTO is produced when given a valid input identifier.
//      */
//     @Test
//     public void testInvalidID() {
//         boolean isValid = false;
//         try {
//             int id = item.getItemID();
//             inventorySystem.getItem(id);
//         } catch (InvalidItemIdentifierException e) {
//             throw new InvalidItemIdentifierException(id);
//         }
//         assertTrue(isValid, "Invalid ID is not caught");
//     }
// }
