package manager;

import controllers.DeliveryController;
import model.Delivery;
import utils.ApplicationException;
import utils.DatabaseMigrator;
import utils.DateTimeUtils;
import java.util.List;

public class DeliveryManager {

    private static DeliveryController deliveryController = new DeliveryController();

    public static void main(String[] args) {
        try {
            DatabaseMigrator.doMigrations();
            if (args.length > 0) {
                String command = args[0];
                if (command.equalsIgnoreCase("adddelivery")) {
                    addDelivery(args);
                }
                if (command.equalsIgnoreCase("updatedelivery")) {
                    updateDelivery(args);
                }
                if (command.equalsIgnoreCase("listdeliveries")) {
                    listDeliveries();
                }
            }
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void addDelivery(String[] args) throws ApplicationException {
        if (args.length != 5) {
            throw (new ApplicationException("parameter: <deliveryDate> <deliveryAddress> <maxWeight> <customerid>"));
        }
        else {
            deliveryController.addDelivery(DateTimeUtils.formatDDMMYYDate(args[1]), args[2], Integer.parseInt(args[3]), Integer.parseInt(args[4]));
        }
    }

    private static void updateDelivery(String[] args) throws ApplicationException {
        if(args.length !=5) {
            throw (new ApplicationException("parameter: <deliveryDate> <deliveryAddress> <maxWeight> <deliveryId>"));
        } else {
            deliveryController.updateDelivery(DateTimeUtils.formatDDMMYYDate(args[1]), args[2], Integer.parseInt(args[3]), Integer.parseInt(args[4]));
        }
    }

    private static void listDeliveries() {
        List<Delivery> deliveries = deliveryController.listDeliveries();
        for (Delivery Delivery : deliveries) {
            System.out.println(Delivery);
        }
    }
}
