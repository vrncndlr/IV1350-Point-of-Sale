package main.se.kth.iv1350.pos.util;

import main.se.kth.iv1350.pos.model.TotalRevenueObserver;
import java.time.LocalDateTime;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class TotalRevenueFileOutput implements TotalRevenueObserver{
    private PrintWriter logger;
    private double totalRevenue = 0;
    /**
     * Creates a new instance that creates a text file and overwrites old ones.
     */
    public TotalRevenueFileOutput() {
        try {
            logger = new PrintWriter(new FileWriter("src/main/se/kth/iv1350/pos/totalRevenue.txt", true));
        } catch (IOException e) {
            System.out.println("Could not write to file.");
        }
    }
    /**
     * Notify observers about change in total revenue and log a specified message
     * @param newRevenue payment of current sale
     */
    public void logRevenue(double newRevenue){
        addRevenue(newRevenue);
        StringBuilder msg = new StringBuilder();
        msg.append(LocalDateTime.now() + " ");
        msg.append("Total revenue: ");
        msg.append(totalRevenue);
        msg.append("\n");
        logger.println(msg);
    }
    /**
     * Adds revenue to the total revenue and shows it.
     * @param newRevenue the newest revenue
     */
    private void addRevenue(double newRevenue) {
        totalRevenue = totalRevenue+newRevenue;
        try {
            logRevenue(newRevenue);
        } catch (Exception ex) {
            System.out.println("Couldn't write total revenue to file.");
        }
    }
    // /**
    //  * Logs the specified total revenue on a text file before closing stream to file
    //  * @param profit the total revenue to be logged
    //  */
    // public void logRevenue(double profit){
    //     StringBuilder msg = new StringBuilder();
    //     msg.append(LocalDateTime.now() + " ");
    //     msg.append("Total revenue: ");
    //     msg.append(profit);
    //     msg.append("\n");
    //     logger.println(msg);
    // }
}
