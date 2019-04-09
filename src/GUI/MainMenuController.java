/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.UUID;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author sebastian
 */
public class MainMenuController implements Initializable {

    @FXML
    private Label nameUser;
    @FXML
    private ListView<String> patientList;

    private SensumInterface fc;
    private ObservableList patients = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameUser.setText(fc.getUserName());
        for (Map.Entry<UUID, String> entry : fc.getPatientsMap().entrySet()) {
            ListPerson lp = new ListPerson(entry.getKey(), entry.getValue());
            patients.add(lp);
        }
        patientList.setItems(patients);
    }

    @FXML
    private void selectPatient(MouseEvent event) {
    }

}
