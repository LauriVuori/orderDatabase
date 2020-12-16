package manager;

import controllers.StoragesController;
import model.Storages;
import utils.ApplicationException;
import utils.DatabaseMigrator;

import java.util.List;

public class StoragesManager {

    private static StoragesController storagescontroller = new StoragesController();

    public static void main(String[] args) {
        try {
            DatabaseMigrator.doMigrations();
            if (args.length > 0) {
                String command = args[0];
                if (command.equalsIgnoreCase("addstorages")) {
                    addStorages(args);
                }
                if (command.equalsIgnoreCase("liststorages")) {
                    listStorages();
                }
            }
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void addStorages(String[] args) throws ApplicationException {
        if (args.length != 3){
            throw (new ApplicationException("parameters: <capacity> <productname>"));
        }
        else{
            storagescontroller.addStorages(Integer.parseInt(args[1]), args[2]);
        }
    }
    private static void listStorages(){
        List<Storages> storagess = storagescontroller.listStorages();
        for (Storages storages : storagess) {
            System.out.println(storages);
        }
    }
}