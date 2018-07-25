package app.controller;

import app.model.Data;
import app.model.Film;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class AddFilmController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField genreField;
    @FXML
    private TextField yearField;
    @FXML
    private TextField producerField;
    @FXML
    private TextField lengthField;
    @FXML
    private Button confirmButton;
    @FXML
    private void initialize(){

        confirmButton.setOnAction(e -> {
            if (nameField.getText().isEmpty() || genreField.getText().isEmpty() || yearField.getText().isEmpty() ||
                    producerField.getText().isEmpty() || lengthField.getText().isEmpty()) {
                Controller.inputAlert("Empty field is found");
            }else if (checkEquality()){
                Controller.inputAlert("Film with this name already exists");
            } else {
                Data.filmList.add(new Film(nameField.getText(), genreField.getText(), Integer.valueOf(yearField.getText()),
                        producerField.getText(), Integer.valueOf(lengthField.getText())));
            }
        });
    }

    private boolean checkEquality() {
        for (Film film: Data.filmList) {
            if(film.getName().equals(nameField.getText())){
                return true;
            }
        }
        return false;
    }
}
