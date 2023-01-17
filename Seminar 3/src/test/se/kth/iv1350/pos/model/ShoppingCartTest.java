package test.se.kth.iv1350.pos.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import main.se.kth.iv1350.pos.view.View;
import main.se.kth.iv1350.pos.controller.Controller;
import main.se.kth.iv1350.pos.model.ShoppingCart;
import main.se.kth.iv1350.pos.integration.InventorySystem;

public class ShoppingCartTest {
    InventorySystem inventoryHandler;
    ShoppingCart ShoppingCart;
    
    @BeforeEach
	void setUp() throws Exception {
        ShoppingCart ShoppingCart = new ShoppingCart(inventoryHandler);
	}

	@AfterEach
	void tearDown() throws Exception {
        
	}

    @Test
    public void testIncrementItemInCart(){
        
    }
}
