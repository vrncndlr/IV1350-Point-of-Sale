package main.se.kth.iv1350.pos.util;

import main.se.kth.iv1350.pos.model.TotalRevenueObserver;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class TotalRevenueFileOutput implements TotalRevenueObserver{
    private PrintWriter logger;

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
     * Logs the specified total revenue on a text file before closing stream to file
     * @param profit the total revenue to be logged
     */
    @Override
    public void logRevenue(double profit){
        StringBuilder msg = new StringBuilder();
        msg.append(LocalDateTime.now() + " ");
        msg.append("Total revenue: ");
        msg.append(profit);
        logger.println(msg);
        // logger.close();
    }
}
