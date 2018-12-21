package com.muhammed.sabry;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        getParseTree();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("Welcome to tiny parser");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        ((Controller) fxmlLoader.getController()).setStage(primaryStage);
        primaryStage.show();
    }

    private void getParseTree() throws RecognitionException {
        try {
            TLLexer lexer = new TLLexer(CharStreams.fromFileName("C:\\Users\\Muhammed\\Desktop\\test1.txt"));
            TLParser parser = new TLParser(new CommonTokenStream(lexer));
            parser.setBuildParseTree(true);
            ParseTree tree = parser.parse();

            Scope scope = new Scope();
            EvalVisitor visitor = new EvalVisitor(scope);
            visitor.visit(tree);
        } catch (Exception e) {
            if (e.getMessage() != null) {
                System.err.println(e.getMessage());
            } else {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
