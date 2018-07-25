package app;

import app.model.Data;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Data.readFile();
        Parent root = FXMLLoader.load(getClass().getResource("view/Login.fxml"));
        primaryStage.getIcons().add(new Image("/img/icon.png"));
        primaryStage.setTitle("Cinema");
        primaryStage.setScene(new Scene(root, 1000, 667));
        primaryStage.getScene().getStylesheets().add("css/JMetroDarkTheme.css");
        primaryStage.getScene().getStylesheets().add("css/background.css");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

