/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import sensum_bosted.DomainFacade;

/**
 * FXML Controller class
 *
 * @author sebastian
 */
public class CreateUserMenuController implements Initializable {

    @FXML
    private TextField nameField;
    @FXML
    private TextField userNameField;
    @FXML
    private TextField passwordField;
    @FXML
    private RadioButton handiRadio;
    @FXML
    private ToggleGroup fieldGroup;
    @FXML
    private RadioButton drugRadio;
    @FXML
    private Button backButton;
    @FXML
    private Button createUserButton;

    private SensumInterface fc;
    private Alert alert;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fc = DomainFacade.getInstance();
    }

    @FXML
    private void goBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/MainMenu.fxml"));
            Scene scene = backButton.getScene();
            Stage currentStage = (Stage) createUserButton.getScene().getWindow();
            currentStage.setHeight(420);
            currentStage.setWidth(620);
            scene.setRoot(root);
        } catch (IOException ex) {
            System.out.println("Error");
        }
    }

    @FXML
    private void createUser(ActionEvent event) {
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Fejl");
        alert.setHeaderText("");

        if (nameField.getText().isEmpty()) {
            alert.setContentText("Intet navn angivet.");
            alert.show();
        } else if (userNameField.getText().isEmpty()) {
            alert.setContentText("Intet username angivet.");
            alert.show();
        } else if (passwordField.getText().isEmpty()) {
            alert.setContentText("Intet password angivet.");
            alert.show();
        } //        else if (fc.createUser(userNameField.getText(), passwordField.getText())) {
        //            try {
        //                Parent root = FXMLLoader.load(getClass().getResource("/GUI/MainMenu.fxml"));
        //                Scene scene = createUserButton.getScene();
        //                scene.setRoot(root);
        //            } catch (IOException ex) {
        //                System.out.println("Error");
        //            }
        //} 
        else {
            alert.setContentText("Patient blev ikke gemt");
            alert.show();
        }
    }

}
