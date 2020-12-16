package model;

import io.ebean.Model;
import io.ebean.annotation.NotNull;
import utils.ApplicationException;
import utils.DateTimeUtils;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;
/**
 * Customer table
 * @param Integer orderid -- auto increment
 * @param Integer deliveryid
 * @param Customer customerid
 * @param Date orderdate
 */
@Entity
public class Orders extends Model {

    @Id
    private Integer orderId;
    @ManyToOne
    private Integer deliveryId;
    @ManyToOne
    private Integer customerId;
    @NotNull
    private Date orderDate;

    public Orders() {
    }

    public Orders(String orderDate) {
        try {
            this.orderDate = DateTimeUtils.formatDDMMYYDate(orderDate);
        } catch (ApplicationException e) {

        }
    }
    @Override
    public String toString() {
        return "order{" +
                "orderId=" + orderId +
                ", deliveryId='" + deliveryId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", orderDate=" + orderDate +
                '}';
    }
    // sets
    public void setCustomerId(Customer customer) {
        this.customerId = customer.getCustomerId();
    }

    public void setDeliveryId(Delivery delivery) {
        this.deliveryId = delivery.getDeliveryId();
    }

    public void setOrderDate(Date orderDate) {this.orderDate = orderDate; }

    public Integer getOrderId(){
        return this.orderId;
    }



}