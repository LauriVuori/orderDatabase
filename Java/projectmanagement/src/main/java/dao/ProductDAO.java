package dao;

import io.ebean.DB;
import model.Product;
import utils.ApplicationException;
import io.ebean.Expr;
import java.util.List;
public class ProductDAO{

    public void addProduct(Product product){
        try {
            product.save();
        } catch (Exception e) {
            System.out.println("Error adding new product: " + e.getMessage());
        }
    }

    public List<Product> listProduct() {
        return DB.find(Product.class).findList();
    }

    public Product getProductId(Integer productId) throws ApplicationException {
        try {
            return DB.find(Product.class).where(Expr.eq("product_id", productId)).findOne();
        } catch (Exception e) {
            throw new ApplicationException("Error in finding the product");
        }
    }

    public Product updateProduct(Product product) {
        product.update();
        return product;
    }
}
