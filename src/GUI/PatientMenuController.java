/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sensum_bosted.DomainFacade;

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
    @FXML
    private Button goBackButton;

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
        patientName.setText(fc.getPatientName());
        patientCPR.setText(fc.getPatientCPR());
        generalInfo.setText(fc.getPatientInfo());
        scheduleButton.setDisable(true);
    }

    @FXML
    private void goToDiary(ActionEvent event) {
        diaryButton.setDisable(true);
        fc.initializeDiary();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/DiaryMenu.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Sensum Bosted");
            stage.setScene(new Scene(root));
            stage.show();
            stage.setX(650);
            stage.setY(250);
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    diaryButton.setDisable(false);
                }
            });

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", ex);
        }
    }

    @FXML
    private void goToSchedule(ActionEvent event) {
    }

    @FXML
    private void goToMainMenu(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/MainMenu.fxml"));
            Scene scene = goBackButton.getScene();
            scene.setRoot(root);
        } catch (IOException ex) {
            System.out.println("Error");
        }
    }

}
