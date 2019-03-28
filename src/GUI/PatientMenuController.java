/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author sebastian
 */
public class PatientMenuController implements Initializable {

    @FXML
    private ImageView patientImage;
    @FXML
    private Label patientName;
    @FXML
    private Label patientCPR;
    @FXML
    private TextArea generalInfo;
    @FXML
    private Button diaryButton;
    @FXML
    private Button scheduleButton;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void goToDiary(ActionEvent event) {
    }

    @FXML
    private void goToSchedule(ActionEvent event) {
    }
    
}
