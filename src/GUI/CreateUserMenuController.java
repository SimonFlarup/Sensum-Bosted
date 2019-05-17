/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
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
    private PasswordField repeatPasswordField;
    @FXML
    private RadioButton handiRadio;
    @FXML
    private RadioButton bothRadio;
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
        String field = "";
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
        } else if (!repeatPasswordField.getText().contains(passwordField.getText()) || repeatPasswordField.getText().isEmpty()) {
            alert.setContentText("kodeordet i 'password' og 'gentag password' stemmer ikke overens.");
            alert.show();
            passwordField.setText("");
            repeatPasswordField.setText("");
        } else if (!handiRadio.isSelected() && !drugRadio.isSelected() && !bothRadio.isSelected()) {
            alert.setContentText("Intet område angivet.");
            alert.show();
        } else {
            if (handiRadio.isSelected()) {
                field = "CARETAKER";
            } else if (drugRadio.isSelected()) {
                field = "CARETAKER_DRUG";
            } else {
                field = "CARETAKER_BOTH";
            }

            if (fc.createUser(userNameField.getText(), passwordField.getText(), field, nameField.getText())) {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/GUI/MainMenu.fxml"));
                    Scene scene = createUserButton.getScene();
                    Stage currentStage = (Stage) createUserButton.getScene().getWindow();
                    currentStage.setHeight(420);
                    currentStage.setWidth(620);
                    scene.setRoot(root);
                } catch (IOException ex) {
                    System.out.println("Error");
                }
            } else {
                alert.setContentText("Bruger blev ikke oprettet.");
                alert.show();
            }
        }
    }

}
