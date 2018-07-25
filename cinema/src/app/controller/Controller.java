package app.controller;

import javafx.scene.control.Alert;

public class Controller {

    public static void loadAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("IOException has occured");
        alert.setContentText("Possibly, FXMLLoader error");
        alert.showAndWait();
    }

    public static void inputAlert(String s){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Input error");
        alert.setContentText(s);
        alert.showAndWait();
    }
}
