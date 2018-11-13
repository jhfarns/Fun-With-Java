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
    private TableView<?> SearchTable;

    @FXML
    private TableColumn<?, ?> SearchTablePartID;

    @FXML
    private TableColumn<?, ?> SearchTablePartName;

    @FXML
    private TableColumn<?, ?> SearchTableInventoryLevel;

    @FXML
    private TableColumn<?, ?> SearchTablePricePerUnit;

    @FXML
    private TableView<?> AssociatedPartTable;

    @FXML
    private TableColumn<?, ?> AssociatedPartsTablePartID;

    @FXML
    private TableColumn<?, ?> AssociatedPartsTablePartName;

    @FXML
    private TableColumn<?, ?> AssociatedPartsTableInventoryLevel;

    @FXML
    private TableColumn<?, ?> AssociatedPartsTablePricePerUnit;

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

}
