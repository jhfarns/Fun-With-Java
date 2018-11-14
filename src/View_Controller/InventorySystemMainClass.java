/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import Model.InhousePart;
import Model.Inventory;
import Model.OutsourcedPart;
import Model.Product;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Jhfar
 */
public class InventorySystemMainClass extends Application {
    
    private Inventory inventory = new Inventory();
    
    public Inventory returnInventory() {  
        return this.inventory;
    }
    
    @Override
    public void start(Stage primaryStage) throws IOException{
        
        inventory.addPart(new InhousePart(1,"string",2.0,2,2,2,2));
        inventory.addPart(new OutsourcedPart(2,"someString",3.0,3,3,3,"CompanyName"));
        inventory.addProduct(new Product(1,"ProductName", 2.0,2,2,2,inventory.lookupPart(1),inventory.lookupPart(2)));
        inventory.addProduct(new Product(2,"ProductName", 2.0,2,2,2,inventory.lookupPart(1),inventory.lookupPart(2)));
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
        Parent root = loader.load();
        MainScreenController controller = loader.getController();
        controller.setInventory(inventory);
        
        
        
        Scene scene = new Scene(root, 1000, 500);
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
       
       
 
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
