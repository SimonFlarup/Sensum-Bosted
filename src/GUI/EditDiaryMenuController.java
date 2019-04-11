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
    private Label notationID;
    @FXML
    private Button backButton;
    @FXML
    private Label saveSuccessful;

    private SensumInterface fc;
    private Alert alert;
    private boolean goBack;

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
            saveSuccessful.setText("Ændringerne blev gemt.");
        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Notation blev ikke gemt");
            alert.setTitle("Advarsel");
            alert.setHeaderText("");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }

    @FXML
    private void goBack(ActionEvent event) {
        goBack = true;
        if (!fc.getNotation().equals(notationText.getText())) {
        alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Vil du forlade dette vindue? Alt data, der ikke er gemt bliver mistet.");
        alert.setTitle("Advarsel");
        alert.setHeaderText("");
        Optional<ButtonType> result = alert.showAndWait();
        goBack = result.get().equals(ButtonType.OK);
        }
        if (goBack) {
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
