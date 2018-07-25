package app.controller;

import app.model.Data;
import app.model.Hall;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddHallController {

    @FXML
    private TextField idField;
    @FXML
    private TextField capacityField;
    @FXML
    private Button confirmButton;
    @FXML
    private void initialize(){

        confirmButton.setOnAction(e -> {
            if (idField.getText().isEmpty() || capacityField.getText().isEmpty()) {
                Controller.inputAlert("Empty field is found");
            } else if (checkEquality()){
                Controller.inputAlert("Hall with this ID already exists");
            } else {
                Data.hallList.add(new Hall(Integer.valueOf(idField.getText()),Integer.valueOf(capacityField.getText())));
            }
        });
    }

    private boolean checkEquality() {
        for (Hall hall: Data.hallList) {
            if(hall.getId() == Integer.valueOf(idField.getText())){
                return true;
            }
        }
        return false;
    }
}
