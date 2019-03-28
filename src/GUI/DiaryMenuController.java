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
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author sebastian
 */
public class DiaryMenuController implements Initializable {

    @FXML
    private ListView<?> diaryList;
    @FXML
    private Button backButton;
    @FXML
    private Button editButton;
    @FXML
    private Button newDiaryButton;

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
    private void openDiary(MouseEvent event) {
    }

    @FXML
    private void goBack(ActionEvent event) {
    }

    @FXML
    private void editDiary(ActionEvent event) {
    }

    @FXML
    private void createNewDiary(ActionEvent event) {
    }
    
}
