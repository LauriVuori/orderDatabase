package dao;

import io.ebean.DB;
import io.ebean.Expr;
import model.Customer;
import model.Delivery;
import utils.ApplicationException;

public class DeliveryDAO {
    public void addDelivery(Delivery delivery){
        try {
            delivery.save();
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }
    }
    public Delivery getDeliveryId(Integer deliveryId) throws ApplicationException {
        try {
            return DB.find(Delivery.class).where(Expr.eq("delivery_id", deliveryId)).findOne();
        } catch (Exception e) {
            throw new ApplicationException("Error in finding the delivery.");
        }
    }
}
