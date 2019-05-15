/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
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
    private ListView<ListViewInfo> notationList;
    @FXML
    private TextArea notationText;
    @FXML
    private Button newNotationButton;
    @FXML
    private Button historyButton;

    private SensumInterface fc;
    private ObservableList notations = FXCollections.observableArrayList();
    private LocalDate selectedNotationId;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        editButton.setDisable(true);
        historyButton.setDisable(true);
        fc = DomainFacade.getInstance();
        ListViewInfo lvi;
        for (LocalDate d : fc.getNotationsList()) {
            lvi = new ListViewInfo(d);
            notations.add(lvi);
        }
        notationList.setItems(notations.sorted(ListViewInfo.BY_DATE));

    }

    @FXML
    private void openNotation(MouseEvent event) {
        try {
            int selectedNotationIndex = notationList.getSelectionModel().getSelectedIndex();
            selectedNotationId = notationList.getItems().get(selectedNotationIndex).getDate();
            fc.initializeNotation(selectedNotationId);
            notationText.setText(fc.getNotation());
            editButton.setDisable(false);
            historyButton.setDisable(false);
        } catch (ArrayIndexOutOfBoundsException ex) {
            sensum_bosted.PrintHandler.println(ex.getMessage(), true);
        }
    }

    @FXML
    private void editNotation(ActionEvent event) {
        fc.initializeNotation(selectedNotationId);
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/EditDiaryMenu.fxml"));
            Scene scene = editButton.getScene();
            scene.setRoot(root);
        } catch (IOException ex) {
            sensum_bosted.PrintHandler.println("Error loading EditDiary | " + ex.getMessage() + " | ", true);
            ex.printStackTrace();
        }
    }

    @FXML
    private void createNewNotation(ActionEvent event) {
        editButton.setDisable(false);

        if (!notations.isEmpty()) {
            LocalDate notationDate = notationList.getItems().get(0).getDate();
            boolean isToday = notationDate == LocalDate.now();
            if (isToday) {
                selectedNotationId = notationDate;
                editButton.fire();
            } else {
                selectedNotationId = fc.createNotation(LocalDate.now());
                editButton.fire();
            }
        } else {
            selectedNotationId = fc.createNotation(LocalDate.now());
            editButton.fire();
        }
    }

    @FXML
    private void openHistory(ActionEvent event) {
        fc.initializeNotation(selectedNotationId);
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/NotationHistoryWindow.fxml"));
            Scene scene = editButton.getScene();
            scene.setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
