package app.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private Button adminButton;
    @FXML
    private Button userButton;
    @FXML
    private Button exitButton;
    @FXML
    private void initialize() {
        adminButton.setOnAction(event -> {
            try {
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/app/view/AdminPass.fxml"));
                stage.setTitle("Cinema");
                stage.getIcons().add(new Image("/img/icon.png"));
                stage.setScene(new Scene(root, 480, 320));
                stage.getScene().getStylesheets().add("css/JMetroDarkTheme.css");
                stage.getScene().getStylesheets().add("css/adminPassBackground.css");
                stage.show();
            } catch (IOException e) {
                Controller.loadAlert();
            }
        });

        userButton.setOnAction(event -> {
            try {
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/app/view/UserGUI.fxml"));
                stage.setTitle("Cinema");
                stage.getIcons().add(new Image("/img/icon.png"));
                stage.setScene(new Scene(root, 1000, 667));
                stage.getScene().getStylesheets().add("css/JMetroDarkTheme.css");
                stage.getScene().getStylesheets().add("css/background.css");
                stage.show();
            } catch (IOException e) {
                Controller.loadAlert();
            }
        });

        exitButton.setOnAction(event -> {
            System.exit(0);
        });
    }

}
