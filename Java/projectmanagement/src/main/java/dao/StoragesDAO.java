package dao;

import io.ebean.DB;
import model.Storages;
import java.util.List;

public class StoragesDAO{

    public void addStorages(Storages storages){
        try {
            storages.save();
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }
    }

    public List<Storages> listStorages() {
    return DB.find(Storages.class).findList();
    }
}