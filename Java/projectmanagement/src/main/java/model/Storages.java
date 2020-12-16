package model;

import io.ebean.Model;
import io.ebean.annotation.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Storage table
 * @param Integer storagelocation
 * @param String capacity
 * @param String productname
 */

@Entity
public class Storages extends Model {
    @Id
    private Integer storageLocation; // auto increment
    @NotNull
    private Integer capacity;
    private String productName;

    public Storages(){}

    public Storages(Integer capacity, String productname) {
        this.capacity = capacity;
        this.productName = productname;
    }

        @Override
    public String toString() {
        return "Storages{" +
                "storagelocation=" + storageLocation +
                ", capacity='" + capacity + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }
    // sets
    public void setCapacity(Integer capacity){
        this.capacity = capacity;
    }

    public void setProductname(String productname){
        this.productName = productname;
    }

   // gets
    public Integer getCapacity(){
        return this.capacity;
    }

    public Integer getStorageLocation(){
    return this.storageLocation;
}

    public String getProductname(){
        return this.productName;
    }
}