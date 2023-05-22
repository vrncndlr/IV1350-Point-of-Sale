package main.se.kth.iv1350.pos.util;

import java.time.LocalDateTime;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    // private static final String FILE_PATH = "src/main/se/kth/iv1350/pos";
    // private static final String ERROR_FILE = "error-log.txt";
    private PrintWriter logFile;

    public Logger() throws IOException {
        logFile = new PrintWriter(new FileWriter("src/main/se/kth/iv1350/pos/error-log.txt", true));
    }

    /**
     * Writes thrown exception to file erroe-log.txt.
     * @param exception The exception that shall be logged.
     */
    public void logErrorMessage(Exception exception) {
        StringBuilder msg = new StringBuilder();
        msg.append(LocalDateTime.now());
        msg.append(", Exception: ");
        msg.append(exception.getMessage());
        logFile.println(msg);
        exception.printStackTrace(logFile);
        logFile.println("\n");
    }
    public void displayErrorMessage(String msg){
        StringBuilder exception = new StringBuilder();
        exception.append("ERROR: ");
        exception.append(msg);
        exception.append("\n");
        System.out.println(exception);
    }
}
