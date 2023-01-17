package main.se.kth.iv1350.pos.integration;

import java.util.ArrayList;

import main.se.kth.iv1350.pos.DTO.PaymentInfoDTO;
import main.se.kth.iv1350.pos.DTO.SaleStateDTO;

/**
 * Handles the communication to the system that logs all <code>Sale</code>.
 */
public class SalesLog {

	private AccountingHandler accountingHandler;
        private InventorySystem inventoryHandler;
        private ArrayList<PaymentInfoDTO> paymentLog;
        private ArrayList<SaleStateDTO> salesLog;


        /**
         * Creates an instance of a <code>SalesLog</code>.
         * @param accountingHandler Handler of an external accounting system.
         * @param inventoryHandler  Handler of an external inventory system.
         */
	public SalesLog(AccountingHandler accountingHandler, InventorySystem inventoryHandler) {
                this.accountingHandler = accountingHandler;
                this.inventoryHandler = inventoryHandler;
                this.paymentLog = new ArrayList<>() ;
                this.salesLog = new ArrayList<>() ;
	}

        /**
         * Logs the concluded sale and updates the external inventory and accounting system.
         * @param saleStateDTO Final state of the sale, ready to be concluded. 
         * @param paymentInfoDTO contain total price and the exchange of cash for the concluded sale.
         */
        public void logSale(SaleStateDTO saleStateDTO, PaymentInfoDTO paymentInfoDTO) {
                System.out.println("SalesLog: Updating external databases.");
                accountingHandler.sendAccountingInfo(paymentInfoDTO);
                inventoryHandler.sendInventoryInfo(saleStateDTO);
                paymentLog.add(paymentInfoDTO);
                salesLog.add(saleStateDTO);
        }

}