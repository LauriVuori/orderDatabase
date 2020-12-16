package manager;

import controllers.OrdersController;
import utils.ApplicationException;
import utils.DatabaseMigrator;
import utils.DateTimeUtils;

public class OrdersManager {

    private static OrdersController ordersController = new OrdersController();

    public static void main(String[] args) {
        try {
            DatabaseMigrator.doMigrations();
            if (args.length > 0) {
                String command = args[0];
                if (command.equalsIgnoreCase("addorders")) {
                    addOrders(args);
                }
            }
        }catch (Exception e){
            System.out.println("Error adding order: " + e.getMessage());
        }
    }

    private static void addOrders(String[] args) throws ApplicationException {
        if (args.length != 4) {
            throw (new ApplicationException("parameter: <orderDate> <customerId> <deliveryId>"));
        } else {
            ordersController.addOrders(DateTimeUtils.formatDDMMYYDate(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]));
        }
    }
}