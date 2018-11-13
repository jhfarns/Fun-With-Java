/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import Model.Inventory;
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
public class IventorySystemMainClass extends Application {
    
    private Inventory inventory = new Inventory();
    
    public Inventory returnInventory() {  
        return this.inventory;
    }
    
    @Override
    public void start(Stage primaryStage) throws IOException{
        
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource("MainScreen.fxml"));
        
        Scene scene = new Scene(root, 1000, 500);
        
        /*MainScreenController controller = loader.getController();
        controller.setMainClass(this);*/
        
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
