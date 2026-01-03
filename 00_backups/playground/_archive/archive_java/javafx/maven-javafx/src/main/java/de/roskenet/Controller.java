package de.roskenet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Controller {

    @FXML
    private Button button1;

    @FXML
    public void onClickButton1(ActionEvent actionEvent) {
        log.debug("You clicked me!");
        button1.setText("Changed now!");
    }
}
