/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import sensum_bosted.DomainFacade;

/**
 * FXML Controller class
 *
 * @author sebastian
 */
public class MainMenuController implements Initializable {

    @FXML
    private Label nameUser;
    @FXML
    private ListView<ListViewInfo> patientList;
    @FXML
    private Button helpButton;
    @FXML
    private Button createPatientButton;

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
        fc = DomainFacade.getInstance();
        nameUser.setText(fc.getUserName());
        for (Map.Entry<String, String> entry : fc.getPatientsMap().entrySet()) {
            ListViewInfo lvf = new ListViewInfo(entry.getKey(), entry.getValue());
            patients.add(lvf);
        }
        patientList.setItems(patients.sorted());
    }

    @FXML
    private void selectPatient(MouseEvent event) {
        int selectedPatientIndex = patientList.getSelectionModel().getSelectedIndex();
        fc.initializePatient(patientList.getItems().get(selectedPatientIndex).getId());
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/PatientMenu.fxml"));
            Scene scene = nameUser.getScene();
            scene.setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void showHelp(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Klik på en patiens navn for at tilgå dennes "
                + "profil samt muligheder for at tilgå dagbog og planlægning for den pågældende patient.");
        alert.setTitle("Hjælp");
        alert.setHeaderText("");
        alert.show();
    }

    @FXML
    private void createPatient(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/CreatePatientMenu.fxml"));
            Scene scene = nameUser.getScene();
            scene.setRoot(root);
        } catch (IOException ex) {
            System.out.println("Error");
        }
    }

}
