/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import sensum_bosted.DomainFacade;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author sebastian
 */
public class LogInMenuController implements Initializable {
    
    @FXML
    private TextField userName;
    @FXML
    private TextField password;
    @FXML
    private Button loginButton;
    @FXML
    private Label message;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void login(ActionEvent event) {
        SensumInterface df = DomainFacade.getInstance();
        if (df.login(userName.getText(), password.getText())) {
            try {
                Stage currentStage = (Stage) loginButton.getScene().getWindow();
                currentStage.close();
                Parent root = FXMLLoader.load(getClass().getResource("/GUI/MainMenu.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Sensum Bosted");
                stage.getIcons().add(new Image("/images/house.png"));
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.show();
                stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                	@Override
                	public void handle(WindowEvent event) {
                    	Platform.exit();
                	}
            	});
            } catch (IOException ex) {
                Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            message.setText("Invalid credentials!");
            password.setText("");
        }
    }

    @FXML
    private void loginKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            loginButton.fire();
        }
    }

}
