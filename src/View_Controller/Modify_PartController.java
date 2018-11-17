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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class Modify_PartController {

    @FXML
    private RadioButton InhouseRadioButton;

    @FXML
    private ToggleGroup ToggleGroup1;

    @FXML
    private RadioButton OusourcedRadioButton;

    @FXML
    private TextField IdTextfField;

    @FXML
    private TextField PartNameTextField;

    @FXML
    private TextField InventoryTextField;

    @FXML
    private TextField PriceTextField;

    @FXML
    private TextField MaxTextField;

    @FXML
    private TextField MinTextField;

    @FXML
    private TextField MachineIdTextfField;

    @FXML
    private Label MachineIdLabel;

    @FXML
    private Button SaveButton;

    @FXML
    private Button CancelButton;
    
    @FXML
    private AnchorPane rootPane;
    
    private Part selectedPart;
    
    boolean inHouseSelected = true;
    
    
    @FXML
    void updateLabelText(ActionEvent event) {
        /*
        Have this in a try block. If it throws an exception because it cannot
        cast type then have give a pop up and leave the radio button selected
        to the appropriate type. Make sure that it also does not update the 
        label name.
        */
        
        try {
            
            if (InhouseRadioButton.isSelected()){
                InhousePart definedPart = (InhousePart) selectedPart;
                MachineIdLabel.setText("Machine ID");
                MachineIdTextfField.setText(Integer.toString(definedPart.getMachineID()));
            }else {
                OutsourcedPart definedPart = (OutsourcedPart) selectedPart;
                MachineIdLabel.setText("Company Name");
                MachineIdTextfField.setText(definedPart.getCompanyName());
            }
        } catch (ClassCastException radioButton){
            System.out.println(inHouseSelected);
            if (inHouseSelected == true) {
                InhouseRadioButton.setSelected(true);
                System.out.println("inhouse was selected");
            } else {
                OusourcedRadioButton.setSelected(true);
            }
            
            Alert radioAlert = new Alert(AlertType.ERROR, selectedPart.getName() + " Cannot Change if it is an Inhouse or Outsourced Part", ButtonType.OK );
            radioAlert.showAndWait();
        }

    }
       
    public void loadMainScreen (FXMLLoader mainScreen) throws IOException {
        AnchorPane mainScreenPane = mainScreen.load(getClass().getResource("MainScreen.fxml"));
        rootPane.getChildren().setAll(mainScreenPane);
    }
    
    private Inventory inventory;
    
    public void loadInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    
    public void getSelectedPart(Part selectedPart) {
        this.selectedPart = selectedPart;
      
        try {
            OutsourcedPart definedPart = (OutsourcedPart) selectedPart;
            OusourcedRadioButton.setSelected(true);
            MachineIdLabel.setText("Company Name");
            MachineIdTextfField.setText(definedPart.getCompanyName());
            inHouseSelected = false;
        } 
        catch(ClassCastException exception){
            InhousePart definedPart = (InhousePart) selectedPart;
            InhouseRadioButton.setSelected(true);
            MachineIdLabel.setText("Machine ID");
            MachineIdTextfField.setText(Integer.toString(definedPart.getMachineID()));
            inHouseSelected = true;
        }
        finally{
        IdTextfField.setText(Integer.toString(selectedPart.getPartID()));
        PartNameTextField.setText(selectedPart.getName());
        InventoryTextField.setText(Integer.toString(selectedPart.getIntStock()));
        PriceTextField.setText(Double.toString(selectedPart.getPrice()));
        MaxTextField.setText(Integer.toString(selectedPart.getMax()));
        MinTextField.setText(Integer.toString(selectedPart.getMin()));
        
        }
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
    void saveToInventory(ActionEvent event) throws IOException {
        if(InhouseRadioButton.isSelected()){
            InhousePart definedPart = (InhousePart) selectedPart;
            definedPart.setMachineID(Integer.parseInt(MachineIdTextfField.getText()));
        } else {
            OutsourcedPart definedPart = (OutsourcedPart) selectedPart;
            definedPart.setCompanyName(MachineIdTextfField.getText());
        } 
        selectedPart.setName(PartNameTextField.getText());
        selectedPart.setInStock(Integer.parseInt(InventoryTextField.getText()));
        selectedPart.setPrice(Double.parseDouble(PriceTextField.getText()));
        selectedPart.setMax(Integer.parseInt(MaxTextField.getText()));
        selectedPart.setMin(Integer.parseInt(MinTextField.getText()));
        
        FXMLLoader mainScreen = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
        AnchorPane mainScreenPane = mainScreen.load();
        rootPane.getChildren().setAll(mainScreenPane);
        
        MainScreenController mainScreenController = mainScreen.getController();
        mainScreenController.setInventory(inventory);
    }    
}

