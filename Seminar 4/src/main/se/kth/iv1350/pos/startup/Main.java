package main.se.kth.iv1350.pos.startup;

// import main.se.kth.iv1350.pos.model.Register;
import main.se.kth.iv1350.pos.integration.DBHandler;
import main.se.kth.iv1350.pos.integration.IOHandler;
import main.se.kth.iv1350.pos.controller.Controller;
import main.se.kth.iv1350.pos.view.View;

/**
 * Start the entire application, contains the <code>Main</code> method used to start the application.
 */
public class Main {
    /**
     *  Method used to start the application.
     * @param args  The application does not take any command-line parameters
     */  
    public static void main(String [] args) {
        // Register register = new Register();
        DBHandler dbHandler = new DBHandler();
        IOHandler ioHandler = new IOHandler();
        Controller controller = new Controller(dbHandler, ioHandler);
        View view = new View(controller);
        view.sampleStartSale();    
        view.sampleExecution(1);
        view.sampleExecution(2);
        view.sampleExecution(3);
        view.sampleExecution(6);
        view.sampleExecution(500);
        view.sampleEndSale();
        view.sampleRegisterPayment(200);
    }
}
