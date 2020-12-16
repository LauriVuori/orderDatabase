package manager;

import controllers.CustomerController;
import model.Customer;
import utils.ApplicationException;
import utils.DatabaseMigrator;

import java.util.List;

/**
 * Customer CustomerManager
 */
public class CustomerManager {

    private static CustomerController customercontroller = new CustomerController();

    public static void main(String[] args) {
        try {
            DatabaseMigrator.doMigrations();
            if (args.length > 0) {
                String command = args[0];
                if (command.equalsIgnoreCase("addcustomer")) {
                    addCustomer(args);
                }
                if (command.equalsIgnoreCase("listcustomer")){
                    listCustomers();
                }
                if (command.equalsIgnoreCase("updatecustomer")){
                    updateCustomer(args);
                }
            }
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void addCustomer(String[] args) throws ApplicationException {
        if (args.length != 5){
            throw (new ApplicationException("parameters: <company> <forename> <surname> <address>"));
        }
        else{
            customercontroller.addCustomer(args[1], args[2], args[3], args[4]);
        }
    }

    private static void listCustomers(){
        List<Customer> customers = customercontroller.listCustomer();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
    private static void updateCustomer(String[] args) throws ApplicationException {
        if (args.length != 6){
            throw (new ApplicationException("parameters: <customerId> <company> <forename> <surname> <address>"));
        }
        else{
            // System.out.println("test");
            customercontroller.updateCustomer(Integer.parseInt(args[1]), args[2], args[3], args[4], args[5]);
        }
    }
}