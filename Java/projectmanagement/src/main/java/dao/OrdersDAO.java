package dao;

import io.ebean.DB;
import model.Orders;

import java.util.List;

public class OrdersDAO {
    public void addOrders(Orders orders){
        try {
            orders.save();
        } catch (Exception e) {
            System.out.println("error in orders: " + e.getMessage());
        }
    }
    public List<Orders> listOrders() {
        return DB.find(Orders.class).findList();
    }
}

