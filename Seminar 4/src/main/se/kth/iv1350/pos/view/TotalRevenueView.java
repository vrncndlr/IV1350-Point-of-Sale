package main.se.kth.iv1350.pos.view;
import main.se.kth.iv1350.pos.model.TotalRevenueObserver;

/**
 * Shows total revenue to the user inteface.
 */  
    public class TotalRevenueView implements TotalRevenueObserver{
        /**
         * Logs the specified total revenue on consol
         * @param totalRevenue current profit
         */
        public void logRevenue(double totalRevenue){
            System.out.println("Total revenue: " + totalRevenue);
        }
    }
