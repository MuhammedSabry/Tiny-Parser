package com.muhammed.sabry;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTree;

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
    private File file;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pickFile.setOnMouseClicked(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Pick text file");
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

            file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                textField.setText(file.getPath());
            }
        });

        drawButton.setOnMouseClicked(event -> {
            if (file != null)
                getParseTree(file.getPath());
        });
    }

    private void getParseTree(String fileName) throws RecognitionException {
        try {
            TLLexer lexer = new TLLexer(CharStreams.fromFileName(fileName));
            TLParser parser = new TLParser(new CommonTokenStream(lexer));
            parser.setBuildParseTree(true);
            ParseTree tree = parser.parse();
            SyntaxTree root = new SyntaxTree("Start");
            root.preOrderTraverse(tree, root.getRoot());
        } catch (Exception e) {
            if (e.getMessage() != null) {
                System.err.println(e.getMessage());
            } else {
                e.printStackTrace();
            }
        }
    }

    void setStage(Stage stage) {
        this.stage = stage;
    }
}
