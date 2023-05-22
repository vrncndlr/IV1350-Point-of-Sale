package main.se.kth.iv1350.pos.model;

/**
 * Interface for information about sale, 
 * more specifially method for logging the total revenue
 */
public interface TotalRevenueObserver {
    
    /**
     * Notified observers about change in total revenue by logging a specified message
     * @param profit payment of current sale
     */
    public void logRevenue(double profit);

}
