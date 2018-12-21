package com.muhammed.sabry;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    ScrollPane scrollPane;
    @FXML
    Button drawButton;
    @FXML
    Button pickFile;
    @FXML
    TextField textField;
    private Stage stage;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pickFile.setOnMouseClicked(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Pick text file");
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

            File file = fileChooser.showOpenDialog(stage);
            if (file != null)
                textField.setText(file.getPath());
        });
    }

    void setStage(Stage stage) {
        this.stage = stage;
    }
}
