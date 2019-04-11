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
import javafx.scene.control.Button;
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
    private Label diaryID;
    @FXML
    private Button saveButton;
    @FXML
    private Button cancelButton;
    @FXML
    private TextArea notationText;
    @FXML
    private Label saveSuccessful;

    private SensumInterface fc;
    private boolean saved = true;




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
    }

    @FXML
    private void saveNotation(ActionEvent event) {        
        saved = fc.saveNotation(notationText.getText());
        if (saved) {
            saveSuccessful.setText("Notation blev gemt (eller gjorde den)");
        } else {
            saveSuccessful.setText("Notation blev ikke gemt");
        }
    }

    @FXML
    private void cancelNotationEdit(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/DiaryMenu.fxml"));
            Scene scene = cancelButton.getScene();
            scene.setRoot(root);
        } catch (IOException ex) {
            System.out.println("Error");
        }
    }

}
