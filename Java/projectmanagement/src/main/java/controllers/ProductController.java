package controllers;
import controllers.StoragesController;
import dao.ProductDAO;
import model.Product;
import java.util.List;
import model.Storages;
import utils.ApplicationException;


public class ProductController {
    ProductDAO productDAO = new ProductDAO();
    public void addProduct(String productname, Integer price, Integer size, Integer weight) {
        try{
            Product product = new Product();
            product.setProductname(productname);
            product.setPrice(price);
            product.setSize(size);
            product.setWeight(weight);

        } catch (Exception e) {
                System.out.println("<<<Controller<<<<<Error setting storagelocation " + e.getMessage());
        }
    }

    public Product getProductId(Integer productId) throws ApplicationException {
        try {
            return productDAO.getProductId(productId);
        } catch (Exception e) {
            throw (new ApplicationException("Failed getting productid", e));
        }
    }

    public List<Product> listProduct() {
        return productDAO.listProduct();
    }

    public void updateProduct(Integer productId, String productname, Integer price, Integer size, Integer weight) {
        try {
            Product product = getProductId(productId);
            if (product != null) {
                try{
                    product.setProductname(productname);
                    product.setPrice(price);
                    product.setSize(size);
                    product.setWeight(weight);
                } catch (Exception e){
                    System.out.println("Error updating product: " + e.getMessage());
                }
            }
            else{
                System.out.println("Cannot find product, try another id.");
            }
        } catch (Exception e) {
            System.out.println("Error finding customer: " + e.getMessage());
        }
    }
}