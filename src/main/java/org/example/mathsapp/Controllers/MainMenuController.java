package org.example.mathsapp.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import org.example.mathsapp.HelloApplication;


import java.io.IOException;

public class MainMenuController {
    @FXML
    private Pane Pane;

    @FXML
    void Exit(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void FeesMark(MouseEvent event) {
        try {
            Pane load = FXMLLoader.load(HelloApplication.class.getResource("view/FeesMark-view.fxml"));
            Pane.getChildren().setAll(load);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void HomeWork(MouseEvent event) {
        try {
            Pane load = FXMLLoader.load(HelloApplication.class.getResource("view/Home-Work-view.fxml"));
            Pane.getChildren().setAll(load);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void Student(MouseEvent event) {
        try {
            Pane load = FXMLLoader.load(HelloApplication.class.getResource("view/Add-Student-view.fxml"));
            Pane.getChildren().setAll(load);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
