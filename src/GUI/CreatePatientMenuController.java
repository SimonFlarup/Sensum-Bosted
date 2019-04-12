/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import sensum_bosted.DomainFacade;

/**
 * FXML Controller class
 *
 * @author KV
 */
public class CreatePatientMenuController implements Initializable {

    @FXML
    private TextField nameField;
    @FXML
    private TextArea infoArea;
    @FXML
    private TextField cprField;
    @FXML
    private Button backButton;
    @FXML
    private Button saveButton;

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
    private void savePatient(ActionEvent event) {
        if (fc.createPatient(nameField.getText(), cprField.getText(), infoArea.getText())) {
            if (cprField.getText().contains("-") && cprField.getText().length() == 11) {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/GUI/MainMenu.fxml"));
                    Scene scene = saveButton.getScene();
                    scene.setRoot(root);
                } catch (IOException ex) {
                    System.out.println("Error");
                }
            } else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Ugyldigt CPR nummer.");
                alert.setTitle("Fejl");
                alert.setHeaderText("");
                alert.show();
            }
        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Patient blev ikke gemt");
            alert.setTitle("Fejl");
            alert.setHeaderText("");
            alert.show();
        }

    }

    @FXML
    private void goBack(ActionEvent event) {
        alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Ingen patient oprettet. Gå tilbage?");
        alert.setTitle("Advarsel");
        alert.setHeaderText("");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get().equals(ButtonType.OK)) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/GUI/MainMenu.fxml"));
                Scene scene = saveButton.getScene();
                scene.setRoot(root);
            } catch (IOException ex) {
                System.out.println("Error");
            }
        }
    }

}
