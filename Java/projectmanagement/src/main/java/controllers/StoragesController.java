package controllers;

import dao.StoragesDAO;
import model.Storages;
import java.util.List;



public class StoragesController {

    StoragesDAO storagesDAO = new StoragesDAO();

    public void addStorages(Integer capacity, String productName) {
        try{
            Storages storages = new Storages();
            storages.setCapacity(capacity);
            storages.setProductname(productName);
            storagesDAO.addStorages(storages);
        } catch (Exception e){
            System.out.println("Error adding storages: " + e.getMessage());
        }
    } 

    public List<Storages> listStorages() {
        return storagesDAO.listStorages();
    }
}
