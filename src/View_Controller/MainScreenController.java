/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import Model.InhousePart;
import Model.Part;
import Model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainScreenController {
    
    private IventorySystemMainClass mainClass;
    
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
    
    public ObservableList<Part> list = FXCollections.observableArrayList(
        new InhousePart(8,"newPart",2.0,4,4,4,4)
    
        );
    
    public void initialize() {
        PartsTablePartID.setCellValueFactory(new PropertyValueFactory<Part, Integer>("Part ID"));
        PartsTablePartName.setCellValueFactory(new PropertyValueFactory<Part, String>("Part Name"));
        PartsTableInventoryLevel.setCellValueFactory(new PropertyValueFactory<Part, Integer>("Part Level"));
        PartsTablePrice.setCellValueFactory(new PropertyValueFactory<Part, Double>("Part Price"));
        PartsTable.setItems(list);
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

}

