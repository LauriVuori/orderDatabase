package dao;

import model.Orders;

public class OrdersDAO {
    public void addOrders(Orders orders){
        try {
            orders.save();
        } catch (Exception e) {
            System.out.println("error in orders: " + e.getMessage());
        }
    }
}