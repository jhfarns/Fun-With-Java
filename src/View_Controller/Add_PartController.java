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

}
