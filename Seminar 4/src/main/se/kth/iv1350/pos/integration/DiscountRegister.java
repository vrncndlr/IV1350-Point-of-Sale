package main.se.kth.iv1350.pos.integration;

/**
 * Class <code>DiscountRegister</code> containing information about available discounts.
 * 
 */
public class DiscountRegister {
	private String[] registered = {"961023", "870216"};

    /**
     * Creates an instance of the handler for the <code>DiscountRegister</code>. 
     * 
     */
	public DiscountRegister() {
	}

	/**
	 * Method for adding a new customer to the discount elligablility 
	 * @param id
	 */
	public void addNewCustomer(String customerID){
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<registered.length; i++)
			sb.append(registered[i]);
		
		sb.append(customerID);
	}
	public boolean isElligable(String customerID){
		for(int i=0; i<registered.length; i++){
			if(registered[i]==customerID){
				return true;
			}
		}
		return false;
	}

	/**
	 * Applies 10% discount if customer is elligable.
	 * @param customerID
	 */
	public double getDiscount(String customerID) {
		if(isElligable(customerID)){
			System.out.println("DiscountRegister: 10% discount applied.");
			return 0.9;
		}
		else{
			System.out.println("DiscountRegister: No discounts found.");
			return 1.0;
		}
	}

}
