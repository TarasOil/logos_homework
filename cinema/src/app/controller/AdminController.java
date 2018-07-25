package app.controller;

import app.model.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminController {
    @FXML
    private TableView filmTable;
    @FXML
    private TableView sessionTable;
    @FXML
    private TableView hallTable;
    @FXML
    private TableColumn filmNameCol;
    @FXML
    private TableColumn filmGenreCol;
    @FXML
    private TableColumn filmYearCol;
    @FXML
    private TableColumn filmProducerCol;
    @FXML
    private TableColumn filmLengthCol;
    @FXML
    private TableColumn sessionFilmCol;
    @FXML
    private TableColumn sessionHallCol;
    @FXML
    private TableColumn sessionDateCol;
    @FXML
    private TableColumn hallIdCol;
    @FXML
    private TableColumn hallCapacityCol;
    @FXML
    private Button addFilmButton;
    @FXML
    private Button deleteFilmButton;
    @FXML
    private Button addSessionButton;
    @FXML
    private Button deleteSessionButton;
    @FXML
    private Button addHallButton;
    @FXML
    private Button deleteHallButton;
    @FXML
    private void initialize(){

        filmNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        filmGenreCol.setCellValueFactory(new PropertyValueFactory<>("genre"));
        filmYearCol.setCellValueFactory(new PropertyValueFactory<>("year"));
        filmProducerCol.setCellValueFactory(new PropertyValueFactory<>("producer"));
        filmLengthCol.setCellValueFactory(new PropertyValueFactory<>("length"));
        filmTable.setItems(Data.filmList);

        sessionFilmCol.setCellValueFactory(new PropertyValueFactory<>("film"));
        sessionHallCol.setCellValueFactory(new PropertyValueFactory<>("hall"));
        sessionDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        sessionTable.setItems(Data.sessionList);

        hallIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        hallCapacityCol.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        hallTable.setItems(Data.hallList);

        addFilmButton.setOnAction(e -> {
            try {
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/app/view/AddFilmDialog.fxml"));
                stage.setTitle("Cinema");
                stage.getIcons().add(new Image("/img/icon.png"));
                stage.setScene(new Scene(root, 480, 320));
                stage.getScene().getStylesheets().add("css/JMetroDarkTheme.css");
                stage.getScene().getStylesheets().add("css/dialogBackground.css");
                stage.show();
            } catch (IOException exception) {
                Controller.loadAlert();
            }
        });
        deleteFilmButton.setOnAction(e -> {
            int selectedItem = filmTable.getSelectionModel().getSelectedIndex();
            if(selectedItem == -1){
            } else {
                Data.filmList.remove(selectedItem);
            }
        });

        addSessionButton.setOnAction(e -> {
            try {
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/app/view/AddSessionDialog.fxml"));
                stage.setTitle("Cinema");
                stage.getIcons().add(new Image("/img/icon.png"));
                stage.setScene(new Scene(root, 480, 320));
                stage.getScene().getStylesheets().add("css/JMetroDarkTheme.css");
                stage.getScene().getStylesheets().add("css/dialogBackground.css");
                stage.show();
            } catch (IOException exception) {
                Controller.loadAlert();
            }
        });
        deleteSessionButton.setOnAction(e -> {
            int selectedItem = sessionTable.getSelectionModel().getSelectedIndex();
            if(selectedItem == -1){
            } else {
                Data.sessionList.remove(selectedItem);
            }
        });

        addHallButton.setOnAction(e -> {
            try {
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/app/view/AddHallDialog.fxml"));
                stage.setTitle("Cinema");
                stage.getIcons().add(new Image("/img/icon.png"));
                stage.setScene(new Scene(root, 480, 320));
                stage.getScene().getStylesheets().add("css/JMetroDarkTheme.css");
                stage.getScene().getStylesheets().add("css/dialogBackground.css");
                stage.show();
            } catch (IOException exception) {
                Controller.loadAlert();
            }
        });
        deleteHallButton.setOnAction(e -> {
            int selectedItem = hallTable.getSelectionModel().getSelectedIndex();
            if(selectedItem == -1){
            } else {
                Data.hallList.remove(selectedItem);
            }
        });
    }
}
