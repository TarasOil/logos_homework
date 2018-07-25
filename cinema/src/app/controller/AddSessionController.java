package app.controller;

import app.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.GregorianCalendar;

public class AddSessionController {

    @FXML
    private TextField filmNameField;
    @FXML
    private TextField hallIdField;
    @FXML
    private TextField dateField;
    @FXML
    private TextField timeField;
    @FXML
    private Button confirmButton;
    @FXML
    private void initialize() {

        confirmButton.setOnAction(e -> {
            if(filmNameField.getText().isEmpty() || hallIdField.getText().isEmpty() ||
                    dateField.getText().isEmpty() || timeField.getText().isEmpty()){
                Controller.inputAlert("Empty field is found");
            } else if(!checkAvailability()){
                Controller.inputAlert("Possible reasons: duplicate session, occupied hall");
            } else {
                String[] date = dateField.getText().split("/");
                String[] time = timeField.getText().split(":");
                CustomDate dateAndTime = new CustomDate(Integer.valueOf(date[2]),Integer.valueOf(date[1])-1,
                        Integer.valueOf(date[0]),Integer.valueOf(time[0]), Integer.valueOf(time[1]));
                Film film = findFilm(filmNameField.getText());
                Hall hall = findHall(Integer.valueOf(hallIdField.getText()));
                if(film.equals(null)|| hall.equals(null)) {
                    Controller.inputAlert("No film or hall found");
                } else {
                    Data.sessionList.add(new Session(film, hall, dateAndTime));
                }
            }
        });
    }

    private boolean checkAvailability() {
        String[] date = dateField.getText().split("/");
        String[] time = timeField.getText().split(":");
        GregorianCalendar dateAndTime = new GregorianCalendar(Integer.valueOf(date[2]),Integer.valueOf(date[1])-1,
                Integer.valueOf(date[0]),Integer.valueOf(time[0]), Integer.valueOf(time[1]));
        for (Session session: Data.sessionList) {
            if(session.getFilm().getName().equals(filmNameField.getText()) &&
                    session.getHall().getId() == Integer.valueOf(hallIdField.getText()) &&
                    session.getDate().equals(dateAndTime)){
                return false;
            } else if(session.getHall().getId() == Integer.valueOf(hallIdField.getText()) &&
                    session.getDate().equals(dateAndTime)){
                return false;
            }
        }
        return true;
    }

    private Film findFilm(String name) {
        for (Film film : Data.filmList) {
            if(film.getName().equals(name)){
                return film;
            }
        }
        return null;
    }

    private Hall findHall(int id) {
        for (Hall hall : Data.hallList) {
            if(hall.getId() == id){
                return hall;
            }
        }
        return null;
    }
}
