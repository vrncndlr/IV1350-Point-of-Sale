package main.se.kth.iv1350.pos.integration;

import java.util.ArrayList;
import main.se.kth.iv1350.pos.DTO.PaymentInfoDTO;
import main.se.kth.iv1350.pos.DTO.SaleStateDTO;

/**
 * Handles the communication to the system that logs all <code>Sale</code>.
 */
public class SalesLog {
        private ArrayList<SaleStateDTO> salesLog;
        /**
         * Creates an instance of a <code>SalesLog</code>.
         * @param accountingHandler Handler of an external accounting system.
         * @param inventoryHandler  Handler of an external inventory system.
         */
	public SalesLog() {
                this.salesLog = new ArrayList<>() ;
	}
        /**
         * Dummy function
         * Logs the concluded sale and updates the external inventory and accounting system.
         * @param saleStateDTO Final state of the sale, ready to be concluded. 
         * @param paymentInfoDTO contain total price and the exchange of cash for the concluded sale.
         */
        public void logSale(SaleStateDTO currentSale) {
                salesLog.add(currentSale);
        }

}