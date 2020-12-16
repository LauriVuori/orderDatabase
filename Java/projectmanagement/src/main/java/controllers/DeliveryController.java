package controllers;

import dao.DeliveryDAO;
import model.Customer;
import model.Delivery;
import utils.ApplicationException;

import java.util.Date;

public class DeliveryController {

    private static DeliveryDAO deliveryDAO = new DeliveryDAO();
    private static CustomerController customercontroller = new CustomerController();

        public void addDelivery(Date deliveryDate, String deliveryAddress, Integer maxWeight, Integer customerId) {
            try {
                Delivery delivery = new Delivery();
                delivery.setDeliveryDate(deliveryDate);
                delivery.setDeliveryAddress(deliveryAddress);
                delivery.setMaxWeight(maxWeight);
                try {
                    Customer customer = customercontroller.getCustomerId(customerId);
                    if (customer != null) {
                        delivery.setCustomerId(customer);
                    }
                    // else ??
                } catch (Exception e) {
                    System.out.println("Error adding customerid: " + e.getMessage());
                }
                deliveryDAO.addDelivery(delivery);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    public Delivery getDeliveryId(Integer deliveryId) throws ApplicationException {
        try {
            return deliveryDAO.getDeliveryId(deliveryId);
        } catch (Exception e) {
            throw (new ApplicationException("Getting delivery failed.", e));
        }
    }
}
