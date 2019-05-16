/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Map;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import sensum_bosted.DomainFacade;

/**
 * FXML Controller class
 *
 * @author sebastian
 */
public class NotationHistoryWindowController implements Initializable {

    @FXML
    private ListView<ListViewInfo> notationHistoryList;
    @FXML
    private Label userLabel;
    @FXML
    private TextArea notationField;
    @FXML
    private Button backButton;
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
        fc = DomainFacade.getInstance();
        for (Map.Entry<LocalDateTime, String[]> entry : fc.getNotationHistory().entrySet()) {
            ListViewInfo lvf = new ListViewInfo(entry.getKey(), entry.getValue());
            notations.add(lvf);
        }
        notationHistoryList.setItems(notations.sorted(ListViewInfo.BY_TIME));
    }

    @FXML
    private void selectNotation(MouseEvent event) {
        try {
            int selectedNotationIndex = notationHistoryList.getSelectionModel().getSelectedIndex();
            userLabel.setText(notationHistoryList.getItems().get(selectedNotationIndex).getUsername());
            notationField.setText(notationHistoryList.getItems().get(selectedNotationIndex).getContent());
        } catch (ArrayIndexOutOfBoundsException ex) {
            sensum_bosted.PrintHandler.println(ex.getMessage(), true);
        }
    }

    @FXML
    private void goBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/DiaryMenu.fxml"));
            Scene scene = backButton.getScene();
            scene.setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
