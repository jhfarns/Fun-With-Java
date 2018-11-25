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
import java.util.Arrays;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class Modify_ProductController {

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
    private TableView<Part> InventoryTable;

    @FXML
    private TableColumn<Part, Integer> InventoryTablePartID;

    @FXML
    private TableColumn<Part, String> InventoryTablePartName;

    @FXML
    private TableColumn<Part, Integer> InventoryTableInventoryLevel;

    @FXML
    private TableColumn<Part, Double> InventoryTablePricePerUnit;

    @FXML
    private TableView<Part> AssociatedPartsTable;

    @FXML
    private TableColumn<Part, Integer> AssociatedPartsTablePartId;

    @FXML
    private TableColumn<Part, String> AssociatedPartsTablePartName;

    @FXML
    private TableColumn<Part, Integer> AssocaitedPartsTableInventoryLevel;

    @FXML
    private TableColumn<Part, Double> AssociatedPartsTablePricePerUnit;

    @FXML
    private TextField InventoryTableTextField;

    @FXML
    private Button InventoryTableSearchButton;

    @FXML
    private Button SaveButton;

    @FXML
    private Button CancelButton;

    @FXML
    private Button AssociatedPartsTableDeleteButton;

    @FXML
    private Button InventoryTableAddButton;
    
    @FXML
    private AnchorPane rootPane;
    
    private Inventory inventory;
    
    private Product selectedProduct;
    
    private ObservableList<Part> controlListAssociatedParts = FXCollections.observableArrayList();
   
    public void initialize () {
        InventoryTablePartID.setCellValueFactory(new PropertyValueFactory<Part, Integer>("partID"));
        InventoryTablePartName.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
        InventoryTableInventoryLevel.setCellValueFactory(new PropertyValueFactory<Part, Integer>("partLevel"));
        InventoryTablePricePerUnit.setCellValueFactory(new PropertyValueFactory<Part, Double>("partPrice"));

        AssociatedPartsTablePartId.setCellValueFactory(new PropertyValueFactory<Part, Integer>("partID"));
        AssociatedPartsTablePartName.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
        AssocaitedPartsTableInventoryLevel.setCellValueFactory(new PropertyValueFactory<Part, Integer>("partLevel"));
        AssociatedPartsTablePricePerUnit.setCellValueFactory(new PropertyValueFactory<Part, Double>("partPrice"));
    }
    /*
    -Add a new temporary value to the list - will require default construct of
    defualt types new Product()
    -Cancel button to remove temporary product from inventory list of products
    */
    public void loadInventory(Inventory inventory) {
        this.inventory = inventory;
        InventoryTable.setItems(this.inventory.returnAllParts());
    }
    /*
    -Update the constructor for product to auto generate an ID.
    -Handle Cancel button
    -Handle save button
    -Handle search button
    -Handle Add button: get selected field, addPart to selectedProduct,
    setitems on table to returnallparts of selectedparts.
    */
    public void getSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
        AssociatedPartsTable.setItems(selectedProduct.returnAllParts());
        this.controlListAssociatedParts.addAll(selectedProduct.returnAllParts());

        IdTextField.setText(Integer.toString(selectedProduct.getProductID()));
        InventoryTextField.setText(Integer.toString(selectedProduct.getInStock()));
        ProductNameTextField.setText(selectedProduct.getName());
        MinTextField.setText(Integer.toString(selectedProduct.getMin()));
        MaxTextField.setText(Integer.toString(selectedProduct.getMax()));
        PriceTextField.setText(Double.toString(selectedProduct.getPrice()));

    }
    
    @FXML
    void searchButtonParts(ActionEvent event) {
        String searchValue = InventoryTableTextField.getText().toLowerCase();
        /*Try to see if you can be changed to an int. If you can change over 
        to that type and search, if not stay as string
        */
        try {
            int newSearchValue = Integer.parseInt(searchValue);
            InventoryTable.setItems(inventory.searchParts(newSearchValue));
        }
        catch (NumberFormatException exception){
            InventoryTable.setItems(inventory.searchParts(searchValue));
        }
    }

    @FXML
    void saveToInventory(ActionEvent event) throws IOException {

        if(!selectedProduct.returnAllParts().isEmpty()) {
            selectedProduct.setName(ProductNameTextField.getText());
            selectedProduct.setInStock(Integer.parseInt(InventoryTextField.getText()));
            selectedProduct.setPrice(Double.parseDouble(PriceTextField.getText()));
            selectedProduct.setMax(Integer.parseInt(MaxTextField.getText()));
            selectedProduct.setMin(Integer.parseInt(MinTextField.getText()));

            FXMLLoader mainScreen = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
            AnchorPane mainScreenPane = mainScreen.load();
            rootPane.getChildren().setAll(mainScreenPane);

            MainScreenController mainScreenController = mainScreen.getController();
            mainScreenController.setInventory(inventory);
        } else {
            Alert isEmpty = new Alert(Alert.AlertType.INFORMATION);
            isEmpty.setContentText("The product must have at least one part.");
            isEmpty.showAndWait();
        }
        
    }    
    
    @FXML
    void cancelModifyButton(ActionEvent event) throws IOException {
        this.selectedProduct.removeAllAssociatedParts();
        this.selectedProduct.addAssociatedPart(controlListAssociatedParts.toArray(new Part[0]));
        
        FXMLLoader mainScreen = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
        AnchorPane mainScreenPane = mainScreen.load();
        rootPane.getChildren().setAll(mainScreenPane);
        
        MainScreenController mainScreenController = mainScreen.getController();
        mainScreenController.setInventory(inventory);
    }
    
    @FXML
    void deletePartAssociatedPartsTable(ActionEvent event) {
        Part selectedPart = AssociatedPartsTable.getSelectionModel().getSelectedItem();
                
        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        confirmation.setContentText("Are you sure you would like to delete this Product?");
        
        if(selectedPart != null) {
            confirmation.showAndWait();        
            if(confirmation.getResult() == ButtonType.OK) {
            this.selectedProduct.removeAssociatedPart(selectedPart.getPartID());

            }
        } else {
            Alert notSelected = new Alert(Alert.AlertType.INFORMATION);
            notSelected.setContentText("You need to select a Product to delete");
            notSelected.showAndWait();
            
            }
    }
    
    @FXML
    void addAPart(ActionEvent event) {
      Part selectedPart = InventoryTable.getSelectionModel().getSelectedItem();
      this.selectedProduct.addAssociatedPart(selectedPart);
    }
}
