package app.controller;

import app.model.CustomDate;
import app.model.Data;
import app.model.Film;
import app.model.Session;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.stream.Collectors;

public class UserController {
    @FXML
    private TableView filmTable;
    @FXML
    private TableView sessionTable;
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
    private ComboBox weekComboBox;
    @FXML
    private Button restoreButton;
    @FXML
    private void initialize() {

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

        weekComboBox.getItems().addAll("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");

        filmTable.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            Film film = (Film) filmTable.getSelectionModel().getSelectedItem();
            ObservableList<Session> sessionFilterList = Data.sessionList.stream()
                    .filter(el -> el.getFilm().getName().equals(film.getName()))
                    .collect(Collectors.toCollection(FXCollections::observableArrayList));
            sessionTable.setItems(sessionFilterList);
        });

        weekComboBox.setOnAction(e -> {
            int itemIndex = weekComboBox.getSelectionModel().getSelectedIndex();
            ObservableList<Session> sessionFilterList = Data.sessionList.stream()
                    .filter(el -> el.getDate().get(Calendar.DAY_OF_WEEK) == itemIndex+1)
                    .collect(Collectors.toCollection(FXCollections::observableArrayList));
            sessionTable.setItems(sessionFilterList);
        });

        restoreButton.setOnAction(e -> sessionTable.setItems(Data.sessionList));
    }
}
