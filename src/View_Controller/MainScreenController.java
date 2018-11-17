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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class MainScreenController {
    
    private Inventory inventory;
    
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
        PartsTable.setItems(inventory.returnAllParts());
        ProductsTable.setItems(inventory.returnAllProducts());
    }
    
    @FXML
    private TextField PartTableTextField;

    @FXML
    private Button PartTableSearchButton;

    @FXML
    private TableView<Part> PartsTable;

    @FXML
    private TableColumn<Part, Integer> PartsTablePartID;

    @FXML
    private TableColumn<Part, String> PartsTablePartName;

    @FXML
    private TableColumn<Part, Integer> PartsTableInventoryLevel;

    @FXML
    private TableColumn<Part, Double> PartsTablePrice;
    
    public void initialize() {
        PartsTablePartID.setCellValueFactory(new PropertyValueFactory<Part, Integer>("partID"));
        PartsTablePartName.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
        PartsTableInventoryLevel.setCellValueFactory(new PropertyValueFactory<Part, Integer>("partLevel"));
        PartsTablePrice.setCellValueFactory(new PropertyValueFactory<Part, Double>("partPrice"));   
    
        ProductsTablePartID.setCellValueFactory(new PropertyValueFactory<Product, Integer>("productID"));
        ProductsTablePartName.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        ProductsTableInventoryLevel.setCellValueFactory(new PropertyValueFactory<Product, Integer>("inStock"));
        ProductsTablePrice.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));
    }
    
    @FXML
    private Button PartsTableAddButton;

    @FXML
    private Button PartsTableModifyButton;

    @FXML
    private Button PartsTableDeleteButton;

    @FXML
    private Button ProductsTableSearchButton;

    @FXML
    private TextField ProductsTableTextField;
    
    @FXML
    private TextField PartsTableTextField;

    @FXML
    private TableView<Product> ProductsTable;

    @FXML
    private TableColumn<Product, Integer> ProductsTablePartID;

    @FXML
    private TableColumn<Product, String> ProductsTablePartName;

    @FXML
    private TableColumn<Product, Integer> ProductsTableInventoryLevel;

    @FXML
    private TableColumn<Product, Double> ProductsTablePrice;

    @FXML
    private Button ProductsTableAddButton;

    @FXML
    private Button ProductsTableModifyButton;

    @FXML
    private Button ProductsTableDeleteButton;
    
    @FXML
    void searchButtonParts(ActionEvent event) {
        String searchValue = PartsTableTextField.getText().toLowerCase();
        /*Try to see if you can be changed to an int. If you can change over 
        to that type and search, if not stay as string
        */
        try {
            int newSearchValue = Integer.parseInt(searchValue);
            PartsTable.setItems(inventory.searchParts(newSearchValue));
        }
        catch (NumberFormatException exception){
            PartsTable.setItems(inventory.searchParts(searchValue));
        }
    }
        
    @FXML
    void searchButtonProducts(ActionEvent event) {
        String searchValue = ProductsTableTextField.getText().toLowerCase();
        /*Try to see if you can be changed to an int. If you can change over 
        to that type and search, if not stay as string
        */
        try {
            int newSearchValue = Integer.parseInt(searchValue);
            ProductsTable.setItems(inventory.searchProducts(newSearchValue));
        }
        catch (NumberFormatException exception){
            ProductsTable.setItems(inventory.searchProducts(searchValue));
        }
    }
    
    @FXML
    void addPartPartsTable(ActionEvent event) {
       
    }
    
        @FXML
    void deletePartPartsTable(ActionEvent event) {
         Part selectedPart = PartsTable.getSelectionModel().getSelectedItem();
         
         inventory.deletePart(selectedPart);
    }

    @FXML
    void deleteProductProductsTable(ActionEvent event) {
        Product selectedProduct = ProductsTable.getSelectionModel().getSelectedItem();
        
        inventory.removeProduct(selectedProduct.getProductID());
        
    }
    
    @FXML
    AnchorPane rootPane;
    
    @FXML
    void partsModifyButton(ActionEvent event) throws IOException {
        
        Part selectedPart = PartsTable.getSelectionModel().getSelectedItem();
        FXMLLoader modifyPart = new FXMLLoader(getClass().getResource("Modify_Part.fxml"));
        AnchorPane modifiedAnchor = modifyPart.load();
        rootPane.getChildren().setAll(modifiedAnchor);
        
        Modify_PartController modifyController = modifyPart.getController();
        modifyController.getSelectedPart(selectedPart);
        modifyController.loadInventory(inventory);
        
        
    }
    
   
}


