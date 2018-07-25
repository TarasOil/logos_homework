package app.controller;

import app.model.Data;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminPassController {

    @FXML
    private PasswordField passField;
    @FXML
    private Button confirmButton;
    @FXML
    private void initialize(){
        confirmButton.setOnAction(event -> {
            if(passField.getText().isEmpty()){
                Controller.inputAlert("Input field is empty");
            } else if(!passField.getText().equals("admin")){
                Controller.inputAlert("Wrong password");
            } else {
                Stage stage = (Stage) confirmButton.getScene().getWindow();
                stage.close();
                try {
                    stage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("/app/view/AdminGUI.fxml"));
                    stage.setTitle("Cinema");
                    stage.getIcons().add(new Image("/img/icon.png"));
                    stage.setScene(new Scene(root, 1000, 667));
                    stage.getScene().getStylesheets().add("css/JMetroDarkTheme.css");
                    stage.getScene().getStylesheets().add("css/background.css");
                    stage.setOnHiding(e -> {
                        try {
                            Data.writeFile();
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    });
                    stage.show();
                } catch (IOException e) {
                    Controller.loadAlert();
                }
            }
        });
    }


}
