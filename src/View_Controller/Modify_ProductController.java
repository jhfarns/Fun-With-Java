/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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
    private TableView<?> InventoryTable;

    @FXML
    private TableColumn<?, ?> InventoryTablePartID;

    @FXML
    private TableColumn<?, ?> InventoryTablePartName;

    @FXML
    private TableColumn<?, ?> InventoryTableInventoryLevel;

    @FXML
    private TableColumn<?, ?> InventoryTablePricePerUnit;

    @FXML
    private TableView<?> AssociatedPartsTable;

    @FXML
    private TableColumn<?, ?> AssociatedPartsTablePartId;

    @FXML
    private TableColumn<?, ?> AssociatedPartsTablePartName;

    @FXML
    private TableColumn<?, ?> AssocaitedPartsTableInventoryLevel;

    @FXML
    private TableColumn<?, ?> AssociatedPartsTablePricePerUnit;

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

}
