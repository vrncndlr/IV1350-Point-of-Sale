package main.se.kth.iv1350.pos.integration;

/**
 * Class <code>DiscountRegister</code> containing information about available discounts.
 * 
 */
public class DiscountRegister {
	private int elligable;

    /**
     * Creates an instance of the handler for the <code>DiscountRegister</code>. 
     * 
     */
	public DiscountRegister() {
		elligable = 961023;
	}

	/**
	 * Applies 10% discount if customer is elligable.
	 */
	public double getDiscount(int customerID) {
		if(customerID==elligable){
			System.out.println("DiscountRegister: 10% discount applied.");
			return 0.9;
		}
		else{
			System.out.println("DiscountRegister: No discounts found.");
			return 1.0;
		}
	}

}
