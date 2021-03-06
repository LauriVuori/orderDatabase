package dao;

import io.ebean.DB;
import io.ebean.Expr;
import model.Delivery;
import model.Customer;
import model.Delivery;
import utils.ApplicationException;
import java.util.List;

public class DeliveryDAO {
    public void addDelivery(Delivery delivery) {
        try {
            delivery.save();
        } catch (Exception e) {
            System.out.println("Error adding delivery: " + e.getMessage());
        }
    }

    public Delivery updateDelivery(Delivery delivery) throws ApplicationException {
        try {
            delivery.update();
            return delivery;
        } catch (Exception e) {
            throw  new ApplicationException("Error updating delivery");
        }
    }

    public Delivery getDelivery(Integer deliveryId) throws ApplicationException {
        try {
            return DB.find(Delivery.class).where(Expr.eq("delivery_id", deliveryId)).findOne();
        } catch (Exception e) {
            throw new ApplicationException("Error in finding the employee.");
        }
    }
    public Delivery getDeliveryId(Integer deliveryId) throws ApplicationException {
        try {
            return DB.find(Delivery.class).where(Expr.eq("delivery_id", deliveryId)).findOne();
        } catch (Exception e) {
            throw new ApplicationException("Error in finding the delivery.");
        }
    }


    public List<Delivery> listCustomerDeliveries(Integer customerId) {
        return DB.find(Delivery.class).where(Expr.eq("customer_id", customerId)).findList();
    }
    public List<Delivery> listDeliveries(){
        return DB.find(Delivery.class).findList();
    }
}
