package com.itproger.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        Pane root = new Pane();
//        root.setStyle("-fx-background-radius: 6;" +
//                "-fx-background-color: rgb(45, 45, 50), rgb(60, 60, 65);" +
//                "-fx-background-insets: 0, 0 1 1 0;");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main-scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 235, 300);
//        scene.setRoot(root);
        stage.setTitle("Калькулятор");
        stage.setScene(scene);
        //stage.initStyle(StageStyle.DECORATED);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}