package dao;

import io.ebean.DB;
import io.ebean.Expr;
import model.Customer;
import model.Delivery;
import utils.ApplicationException;

import java.util.List;
/**
 * Customer CustomerManager
 */
public class CustomerDAO{
    public void saveCustomer(Customer customer){
        try {
            customer.save();
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }
    }

    public List<Customer> listCustomer() {
        return DB.find(Customer.class).findList();
    }

    public Customer getCustomerId(Integer customerId) throws ApplicationException {
        try {
            return DB.find(Customer.class).where(Expr.eq("customer_id", customerId)).findOne();
        } catch (Exception e) {
            throw new ApplicationException("Error in finding the customer.");
        }
    }

    public Customer listCustomerDeliveries(Integer customerId) {
        Customer customer = DB.find(Customer.class).where(Expr.eq("customer_id", customerId)).findOne();
        Delivery delivery = DB.find(Delivery.class).where(Expr.eq("customer_id", customerId)).findOne();
        System.out.println(customer);
        System.out.println(delivery);
        return customer;
    }
}