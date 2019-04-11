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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import sensum_bosted.DomainFacade;

/**
 * FXML Controller class
 *
 * @author sebastian
 */
public class EditDiaryMenuController implements Initializable {

    @FXML
    private Button saveButton;
    @FXML
    private TextArea notationText;
    @FXML
    private Label saveSuccessful;
    @FXML
    private Label notationID;
    @FXML
    private Button backButton;

    private SensumInterface fc;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fc = DomainFacade.getInstance();
        notationText.setText(fc.getNotation());
        notationID.setText(fc.getNotationDate().toString());
    }

    @FXML
    private void saveNotation(ActionEvent event) {
        if (fc.saveNotation(notationText.getText())) {
            saveSuccessful.setText("Notation blev gemt.");
        } else {
            saveSuccessful.setText("Notation blev ikke gemt");
        }
    }

    @FXML
    private void goBack(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Har du husket at gemme!?");
        alert.setTitle("Advarsel");
        alert.setHeaderText("");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/GUI/DiaryMenu.fxml"));
                Scene scene = saveButton.getScene();
                scene.setRoot(root);
            } catch (IOException ex) {
                System.out.println("Error");
            }
        }
    }

}
