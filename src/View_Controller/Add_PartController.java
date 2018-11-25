/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import Model.InhousePart;
import Model.Inventory;
import Model.OutsourcedPart;
import Model.Part;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class Add_PartController {

    @FXML
    private RadioButton InHouseRadioButton;

    @FXML
    private ToggleGroup ToggleGroup1;

    @FXML
    private RadioButton OutsourcedRadioButton;

    @FXML
    private TextField IdTextField;

    @FXML
    private TextField Name;

    @FXML
    private TextField Inventory;

    @FXML
    private TextField Price;

    @FXML
    private TextField Max;

    @FXML
    private TextField Min;

    @FXML
    private TextField CompanyName;

    @FXML
    private Label CompanyNameLabel;

    @FXML
    private Button SaveButton;

    @FXML
    private Button CancelButton;
    
    @FXML
    private AnchorPane rootPane;
    
    private Inventory inventory;
    
    public void loadInventory(Inventory inventory) {
        this.inventory = inventory;
        OutsourcedRadioButton.setSelected(true);

    }
    
    @FXML
    void reloadMainScreen(ActionEvent event) throws IOException {
        FXMLLoader mainScreen = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
        AnchorPane mainScreenPane = mainScreen.load();
        rootPane.getChildren().setAll(mainScreenPane);
        
        MainScreenController mainScreenController = mainScreen.getController();
        mainScreenController.setInventory(inventory);
    }
    
    @FXML
    void updateLabelText(ActionEvent event) {
        if (InHouseRadioButton.isSelected()){
            CompanyNameLabel.setText("Machine ID");
            CompanyName.setText("MID");
        }else {
            CompanyNameLabel.setText("Company Name");
            CompanyName.setText("Company");
            }
    }
    
    @FXML
    void saveNewPart(ActionEvent event) throws IOException {
        /*
        -You need to add a new constructor for each of the subclasses for part
        -Set inHouseRadioButton
        -Make the Radio button on this page change the label and text field for 
        outsourced vs inhouse.
        */
        
        String partName = Name.getText();
        Double partPrice = Double.parseDouble(Price.getText());
        int partInStock = Integer.parseInt(Inventory.getText());
        int partMin = Integer.parseInt(Min.getText());
        int partMax = Integer.parseInt(Max.getText());
        
        if (InHouseRadioButton.isSelected()){
            int mid = Integer.parseInt(CompanyName.getText());
            Part newPart = new InhousePart(
                inventory,
                partName, 
                partPrice, 
                partInStock, 
                partMin, 
                partMax,
                mid
            );
            
            inventory.addPart(newPart);
        } else {
            String companyName = CompanyName.getText();
            Part newPart = new OutsourcedPart(
                inventory,
                partName, 
                partPrice, 
                partInStock, 
                partMin, 
                partMax,
                companyName
            );
            inventory.addPart(newPart);
        }
        
        FXMLLoader mainScreen = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
        AnchorPane mainScreenPane = mainScreen.load();
        rootPane.getChildren().setAll(mainScreenPane);
        
        MainScreenController mainScreenController = mainScreen.getController();
        mainScreenController.setInventory(inventory);
    }
}
