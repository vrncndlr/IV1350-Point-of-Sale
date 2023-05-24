package main.se.kth.iv1350.pos.util;

import main.se.kth.iv1350.pos.model.TotalRevenueObserver;
import java.time.LocalDateTime;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * 2023-05-23T14:11:09.333840 Total revenue: 163.09
 * 2023-05-23T14:13:56.025975 Total revenue: 326.18
 */

public class TotalRevenueFileOutput implements TotalRevenueObserver{
    private PrintWriter logger;
    private double totalRevenue = 0;
    /**
     * Creates a new instance that creates a text file and overwrites old ones.
     */
    public TotalRevenueFileOutput() throws IOException {
        logger = new PrintWriter(new FileWriter("src/main/se/kth/iv1350/pos/totalRevenue.txt", true));
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
     * Logs the specified total revenue on a text file.
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

}
