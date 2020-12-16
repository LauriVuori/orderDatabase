package controllers;

import dao.CustomerDAO;
import model.Customer;
import model.Delivery;
import utils.ApplicationException;

import java.util.List;


/**
 * Customer CustomerController
 */
public class CustomerController {

    CustomerDAO customerDAO = new CustomerDAO();
    private static DeliveryController deliverycontroller = new DeliveryController();

    public void addCustomer(String company, String forename, String surname, String address) {
        try{
            Customer customer = new Customer();
            customer.setCompany(company);
            customer.setForename(forename);
            customer.setSurname(surname);
            customer.setAddress(address);
            customerDAO.saveCustomer(customer);
        } catch (Exception e){
            System.out.println("Virhe: " + e.getMessage());
        }
    } 

    public List<Customer> listCustomer() {
        return customerDAO.listCustomer();
    }

    public Customer getCustomerId(Integer customerId) throws ApplicationException {
        try {
            return customerDAO.getCustomerId(customerId);
        } catch (Exception e) {
            throw (new ApplicationException("Getting customer failed.", e));
        }
    }

    public void updateCustomer(Integer customerId, String company, String forename, String surname, String address) {
        try {
            Customer customer = getCustomerId(customerId);
            if (customer != null) {
                try{
                    customer.setCompany(company);
                    customer.setForename(forename);
                    customer.setSurname(surname);
                    customer.setAddress(address);
                    customerDAO.saveCustomer(customer);
                } catch (Exception e){
                    System.out.println("Error updating customer data: " + e.getMessage());
                }
            }
            else{
                System.out.println("Cannot find customer, try another id.");
            }
        } catch (Exception e) {
            System.out.println("Error finding customer: " + e.getMessage());
        }
    }

    public void listCustomerDeliveries(Integer customerId) throws ApplicationException {
        Customer customer = getCustomerId(customerId);
        if (customer != null) {
            System.out.println(customer);
            List<Delivery> deliveries = deliverycontroller.listCustomerDeliveries(customerId);
            if (deliveries.size() != 0) {
                for (Delivery delivery : deliveries) {
                    System.out.println(delivery);
                }
            }
            else{
                System.out.println("Cant find any deliveries");
            }
        }
        else{
            System.out.println("Customer not found");
        }
    }
}