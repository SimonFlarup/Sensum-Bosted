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

/**
 * FXML Controller class
 *
 * @author sebastian
 */
public class EditDiaryMenuController implements Initializable {

    @FXML
    private Label diaryID;
    @FXML
    private TextArea diaryText;
    @FXML
    private Button saveButton;
    @FXML
    private Button cancelButton;
    
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
    private void saveDiary(ActionEvent event) {
    }

    @FXML
    private void cancelDiaryEdit(ActionEvent event) {
    }
    
}
