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
        
        inventory.addPart(new InhousePart(inventory,"Spatula",2.0,2,2,2,2));
        inventory.addPart(new OutsourcedPart(inventory,"Krabby Pattie",3.0,3,3,3,"The Krust Crew"));
        inventory.addProduct(new Product(inventory,"Krabby Pattie Burger", 2.0,2,2,2,inventory.lookupPart(0),inventory.lookupPart(1)));
        inventory.addProduct(new Product(inventory,"Is there anything else?", 2.0,2,2,2,inventory.lookupPart(0),inventory.lookupPart(1)));
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
        Parent root = loader.load();
        MainScreenController controller = loader.getController();
        controller.setInventory(inventory);
        
        
        
        Scene scene = new Scene(root, 1000, 800);
        
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
