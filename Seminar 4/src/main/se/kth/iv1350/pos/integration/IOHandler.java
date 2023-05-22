package main.se.kth.iv1350.pos.integration;

import main.se.kth.iv1350.pos.DTO.SaleStateDTO;

public class IOHandler {
    SalesLog salesLog;
    public IOHandler(){
        salesLog = new SalesLog();
    }

    /**
     * Logs most recent sale to a sale history log
     */
    public void updateSaleLog(SaleStateDTO currentSale){
        this.salesLog.logSale(currentSale);
    }

    public void printReceipt(){
        return;
    }
}
