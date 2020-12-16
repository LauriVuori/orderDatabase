package controllers;

import dao.OrdersDAO;
import model.Orders;
import model.Customer;
import model.Delivery;
import utils.ApplicationException;
import java.util.Date;
import java.util.List;


public class OrdersController {

    private static OrdersDAO ordersDAO = new OrdersDAO();
    private static CustomerController customercontroller = new CustomerController();
    private static DeliveryController deliverycontroller = new DeliveryController();

    public void addOrders(Date orderDate, Integer deliveryId, Integer customerId) {
        try {
            Orders orders = new Orders();
            orders.setOrderDate(orderDate);
            try {
                Customer customer = customercontroller.getCustomerId(customerId);
                if (customer != null) {
                    orders.setCustomerId(customer);
                }
            } catch (Exception e) {
                System.out.println("Error adding customerid: " + e.getMessage());
            }
                try {
                    Delivery delivery = deliverycontroller.getDeliveryId(deliveryId);
                    if (delivery != null) {
                        orders.setDeliveryId(delivery);
                    }
                } catch (Exception e) {
                    System.out.println("Error adding deliveryid: " + e.getMessage());
                }


            ordersDAO.addOrders(orders);
        } catch (Exception e) {
            System.out.println("Error in orders: " + e.getMessage());
        }
    }
}