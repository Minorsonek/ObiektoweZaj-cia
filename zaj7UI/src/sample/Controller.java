package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;

public class Controller {

    @FXML
    private void handleOnButtonAction(ActionEvent event)
    {
        System.out.println("Hello world");
    }
}
