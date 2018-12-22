package com.muhammed.sabry;

import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.engine.GraphvizV8Engine;
import guru.nidi.graphviz.model.MutableGraph;
import guru.nidi.graphviz.model.MutableNode;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;

import static guru.nidi.graphviz.model.Factory.graph;
import static guru.nidi.graphviz.model.Factory.mutNode;

public class Controller implements Initializable {
    @FXML
    ScrollPane scrollPane;
    @FXML
    Button drawButton;
    @FXML
    TextField textField;
    @FXML
    ImageView imageView;
    private Stage stage;
    private File file;
    Set<String> nodeData = new TreeSet<>();
    private int i;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Graphviz.useEngine(Collections.singletonList(new GraphvizV8Engine()));
        textField.setEditable(false);
        scrollPane.setFocusTraversable(false);
        textField.setOnMouseClicked(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Pick text file");
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

            file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                textField.setText(file.getPath());
            }
        });

        drawButton.setOnMouseClicked(event -> {
            if (file != null) {
                getParseTree(file.getPath());
                try {
                    imageView.setImage(new Image(new FileInputStream(new File("tree.png"))));
                    imageView.setSmooth(true);
                    imageView.setPreserveRatio(true);
                    imageView.setFitHeight(-1);
                    imageView.setFitWidth(-1);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
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

            MutableNode rootNode = mutNode(root.getRoot().getData());
            MutableGraph graph = ((MutableGraph) graph(root.getRoot().getData()).directed()).add(rootNode);

            i = 0;
            draw(root.getRoot(), rootNode);
            Graphviz.fromGraph(graph).render(Format.PNG).toFile(new File("tree.png"));
        } catch (Exception e) {
            if (e.getMessage() != null) {
                System.err.println(e.getMessage());
            } else {
                e.printStackTrace();
            }
        }
    }

    private void draw(SyntaxTreeNode root, MutableNode rootNode) {
        for (SyntaxTreeNode child : root.getChildren()) {

            StringBuilder leftSpaces = new StringBuilder();
            StringBuilder rightSpaces = new StringBuilder();
            fillSpaces(leftSpaces, rightSpaces);

            String nodeName = leftSpaces.toString() + child.getData() + rightSpaces.toString();
            if (nodeData.contains(nodeName))
                i++;

            leftSpaces = new StringBuilder();
            rightSpaces = new StringBuilder();
            fillSpaces(leftSpaces, rightSpaces);
            nodeName = leftSpaces.toString() + child.getData() + rightSpaces.toString();

            MutableNode graphNode = mutNode(nodeName);
            nodeData.add(nodeName);
            rootNode.addLink(graphNode);
            draw(child, graphNode);
        }
    }

    private void fillSpaces(StringBuilder leftSpaces, StringBuilder rightSpaces) {
        for (int j = 0; j < i; j++) {
            if (j % 2 == 0)
                leftSpaces.append(" ");
            else
                rightSpaces.append(" ");
        }
    }

    void setStage(Stage stage) {
        this.stage = stage;
    }
}
