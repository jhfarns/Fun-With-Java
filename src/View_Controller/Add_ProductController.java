/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import Model.Inventory;
import Model.Part;
import Model.Product;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class Add_ProductController {

    @FXML
    private TextField IdTextField;

    @FXML
    private TextField InventoryTextField;

    @FXML
    private TextField ProductNameTextField;

    @FXML
    private TextField MinTextField;

    @FXML
    private TextField MaxTextField;

    @FXML
    private TextField PriceTextField;

    @FXML
    private TableView<Part> SearchTable;

    @FXML
    private TableColumn<Part, Integer> SearchTablePartID;

    @FXML
    private TableColumn<Part, String> SearchTablePartName;

    @FXML
    private TableColumn<Part, Integer> SearchTableInventoryLevel;

    @FXML
    private TableColumn<Part, Double> SearchTablePricePerUnit;

    @FXML
    private TableView<Part> AssociatedPartTable;

    @FXML
    private TableColumn<Part, Integer> AssociatedPartsTablePartID;

    @FXML
    private TableColumn<Part, String> AssociatedPartsTablePartName;

    @FXML
    private TableColumn<Part, Integer> AssociatedPartsTableInventoryLevel;

    @FXML
    private TableColumn<Part, Double> AssociatedPartsTablePricePerUnit;

    @FXML
    private TextField SearchTextField;

    @FXML
    private Button SearchTableSearchButton;

    @FXML
    private Button SaveButton;

    @FXML
    private Button CancelButton;

    @FXML
    private Button AssociatedPartsTableDeleteButton;

    @FXML
    private Button SearchTableAddButton;
    
    @FXML AnchorPane rootPane;
    
    private Inventory inventory;
    
    private Product temporaryProduct;
    
    /*
    -Search button
    -Add button
    -Delete button
    -Save button
    -Cancel button
    */
    
    public void loadInventory(Inventory inventory) {
        this.inventory = inventory;
        SearchTable.setItems(this.inventory.returnAllParts());
        
        temporaryProduct = new Product();
    }
    
    public void initialize() {
        SearchTablePartID.setCellValueFactory(new PropertyValueFactory<Part, Integer>("partID"));
        SearchTablePartName.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
        SearchTableInventoryLevel.setCellValueFactory(new PropertyValueFactory<Part, Integer>("partLevel"));
        SearchTablePricePerUnit.setCellValueFactory(new PropertyValueFactory<Part, Double>("partPrice"));

        AssociatedPartsTablePartID.setCellValueFactory(new PropertyValueFactory<Part, Integer>("partID"));
        AssociatedPartsTablePartName.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
        AssociatedPartsTableInventoryLevel.setCellValueFactory(new PropertyValueFactory<Part, Integer>("partLevel"));
        AssociatedPartsTablePricePerUnit.setCellValueFactory(new PropertyValueFactory<Part, Double>("partPrice"));
    }
    @FXML
    
        void searchButtonParts(ActionEvent event) {
        String searchValue = SearchTextField.getText().toLowerCase();
        /*Try to see if you can be changed to an int. If you can change over 
        to that type and search, if not stay as string
        */
        try {
            int newSearchValue = Integer.parseInt(searchValue);
            SearchTable.setItems(inventory.searchParts(newSearchValue));
        }
        catch (NumberFormatException exception){
            SearchTable.setItems(inventory.searchParts(searchValue));
        }
    }
    
        
    @FXML
    void saveToInventory(ActionEvent event) throws IOException {
        
        if(!temporaryProduct.returnAllParts().isEmpty()) {
        
            temporaryProduct.setName(ProductNameTextField.getText());
            temporaryProduct.setInStock(Integer.parseInt(InventoryTextField.getText()));
            temporaryProduct.setPrice(Double.parseDouble(PriceTextField.getText()));
            temporaryProduct.setMax(Integer.parseInt(MaxTextField.getText()));
            temporaryProduct.setMin(Integer.parseInt(MinTextField.getText()));
        
            inventory.addProduct(temporaryProduct, true);

            FXMLLoader mainScreen = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
            AnchorPane mainScreenPane = mainScreen.load();
            rootPane.getChildren().setAll(mainScreenPane);

            MainScreenController mainScreenController = mainScreen.getController();
            mainScreenController.setInventory(inventory);
        } else {
            Alert isEmpty = new Alert(AlertType.INFORMATION);
            isEmpty.setContentText("The product must have at least one part.");
            isEmpty.showAndWait();
        }
    }    
    
    @FXML
    void cancelModifyButton(ActionEvent event) throws IOException {
        FXMLLoader mainScreen = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
        AnchorPane mainScreenPane = mainScreen.load();
        rootPane.getChildren().setAll(mainScreenPane);
        
        MainScreenController mainScreenController = mainScreen.getController();
        mainScreenController.setInventory(inventory);
    }
    
    @FXML
    void addAPart(ActionEvent event) {
      Part selectedPart = SearchTable.getSelectionModel().getSelectedItem();
      this.temporaryProduct.addAssociatedPart(selectedPart);
      AssociatedPartTable.setItems(this.temporaryProduct.returnAllParts());
    }
    
    @FXML
    void deletePartAssociatedPartsTable(ActionEvent event) {
        Part selectedPart = AssociatedPartTable.getSelectionModel().getSelectedItem();
        
        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        confirmation.setContentText("Are you sure you would like to delete this Product?");
        
        if(selectedPart != null) {
            confirmation.showAndWait();        
            if(confirmation.getResult() == ButtonType.OK) {
            this.temporaryProduct.removeAssociatedPart(selectedPart.getPartID());
            }
        } else {
            Alert notSelected = new Alert(Alert.AlertType.INFORMATION);
            notSelected.setContentText("You need to select a Product to delete");
            notSelected.showAndWait();
            
            }
    }
}
