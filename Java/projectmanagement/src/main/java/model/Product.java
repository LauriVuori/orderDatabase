package model;

import io.ebean.Model;
import io.ebean.annotation.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

    
    /*
 * Product table
 * @param Integer productid -- auto increment
 * @param String productname
 * @param Integer PRICE
 * @param Integer SIZE
 * @param Integer weight
 * @param Storages STORAGELOCATION
 */
@Entity
public class Product extends Model {

    @Id
    private Integer productId; // auto increment
    @NotNull
    private String productName;
    // Viiteavain project-tauluun (tietenkin sen pääavaimeen)
    // luo tietokantaan kentän nimeltään project_project_id.
    // Muoto perustuu
    // nimeämiseen: <isätaulunnimi>_<isätaulunpääavaimennimi>
    // private Project project
    @NotNull
    private Integer price;
    @NotNull
    private Integer size;
    @NotNull
    private Integer weight;
    @ManyToOne
    private Integer storageLocation;

        public Product() {}

    public Product(String productName, Integer price, Integer size, Integer weight) {
        this.productName = productName;
        this.price = price;
        this.size = size;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price='" + price + '\'' +
                ", size=" + size +
                ", weight='" + weight + '\'' +
                ", storageLocation='" + storageLocation + '\'' +
                '}';
    }

    // sets
    public void setStorageLocation(Storages storages){
        this.storageLocation = storages.getStorageLocation();
    }
    public void setProductname(String productName){
        this.productName = productName;
    }    
    public void setPrice(Integer price){
        this.price = price;
    }
    public void setSize(Integer size){
        this.size = size;
    }  
    public void setWeight(Integer weight){
        this.weight = weight;
    }
    
    // gets

    public Integer getProductId(){
        return this.productId;
    }
}