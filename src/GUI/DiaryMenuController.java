/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.UUID;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import sensum_bosted.DomainFacade;

/**
 * FXML Controller class
 *
 * @author sebastian
 */
public class DiaryMenuController implements Initializable {

    @FXML
    private Button editButton;
    @FXML
    private ListView<ListNotation> notationList;
    @FXML
    private TextArea notationText;
    @FXML
    private Button newNotationButton;

    private SensumInterface fc;
    private ObservableList notations = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        editButton.setDisable(true);
        fc = DomainFacade.getInstance();
        for (Map.Entry<Date, UUID> entry : fc.getNotationsMap().entrySet()) {
            ListNotation ln = new ListNotation(entry.getKey(), entry.getValue());
            notations.add(ln);
        }
        notationList.setItems(notations);
    }

    @FXML
    private void openNotation(MouseEvent event) {
        int selectedNotationIndex = notationList.getSelectionModel().selectedIndexProperty().get();
        editButton.setDisable(false);
        fc.initializeNotation(notationList.getItems().get(selectedNotationIndex).getId());
        notationText.setText(fc.getNotation());
    }

    @FXML
    private void editNotation(ActionEvent event) {
        int selectedNotationIndex = notationList.getSelectionModel().selectedIndexProperty().get();
        fc.initializeNotation(notationList.getItems().get(selectedNotationIndex).getId());
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/EditDiaryMenu.fxml"));
            Scene scene = editButton.getScene();
            scene.setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void createNewNotation(ActionEvent event) {
    }

}
