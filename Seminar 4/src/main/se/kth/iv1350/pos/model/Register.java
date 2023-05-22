package main.se.kth.iv1350.pos.model;

import java.util.ArrayList;
import java.util.List;
import main.se.kth.iv1350.pos.DTO.PaymentInfoDTO;
import main.se.kth.iv1350.pos.DTO.SaleStateDTO;

/**
 * Handles all logic concerning the exchange of cash at the conclusion of a <code>Sale</code>.
 */
public class Register {
        private double balance;
        private double change;
        private List<TotalRevenueObserver> observers = new ArrayList<TotalRevenueObserver>();     

    /**
     * Creates an instance of a <code>Register</code>.
     */
        public Register() {	
                this.balance = 0;
        }

    /**
     * Calculate eventual <code>change</code> after payment is received.
     * @param saleStateDTO final state of the <code>Sale</code>, ready to be concluded. 
     * @param paymentReceived amount received from customer must be greater or equal than the total price.
     * @return contain total price and the exchange of cash for the concluded <code>Sale</code>
     */
        public PaymentInfoDTO calculateChange(SaleStateDTO saleStateDTO, double paymentReceived) {
                double totalPrice = saleStateDTO.getRunningTotal();
                change = (paymentReceived - totalPrice);
                updateBalance(totalPrice);
                PaymentInfoDTO paymentInfoDTO = new PaymentInfoDTO(totalPrice, paymentReceived, Math.round((change*10.0)/10.0));

                return paymentInfoDTO;
        }

        /**
         * Updates the <code>balance</code> in the <code>Register</code> after concluded <code>Sale</code>.
         * @param totalPrice amount to update balance with
         */
        private void updateBalance(double totalPrice) {
                balance = balance + totalPrice;
                this.notifyObservers();
        }
        /**
         * 
         * @param newBalance
         */
        private void notifyObservers() {
                for (TotalRevenueObserver obs : this.observers)
                        obs.logRevenue(this.balance);
                }

        /**
         * Adds an total revenue observer to an array list in the class Register
         * @param obs the total revenue observer in question
         */
        public void addObserver(TotalRevenueObserver obs){
                observers.add(obs);
        }
}

