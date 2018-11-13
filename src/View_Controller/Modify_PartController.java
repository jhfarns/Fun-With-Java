/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

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

}

