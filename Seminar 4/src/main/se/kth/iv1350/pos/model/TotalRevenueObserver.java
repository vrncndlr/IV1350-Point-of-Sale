package main.se.kth.iv1350.pos.model;

/**
 * Interface for information about sale, 
 * more specifially method for logging the total revenue
 */
public interface  TotalRevenueObserver {
    /**
     * Notify observers about change in total revenue and log a specified message
     * @param newRevenue payment of current sale
     */
    public void logRevenue(double newRevenue);

}
