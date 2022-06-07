package com.example.demofxml;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main2  extends Application{
    Stage window;
    Scene scene, scene2;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        // Scene1
        Label label = new Label("Welcome to Howkteam");
        Button button = new Button("Go to course");
        button.setOnAction(actionEvent -> {
            window.setScene(scene2);
        });
        VBox layout1 = new VBox();
        layout1.getChildren().addAll(label,button);
        scene = new Scene(layout1,300,200);

        //scene 2
        Button button1 = new Button(" Go back");
        button1.setOnAction(actionEvent -> {
            window.setScene(scene);
        });
        StackPane layout = new StackPane();
        layout.getChildren().addAll(button1);
        scene2 = new Scene(layout,200,300);
        window.setScene(scene);
        window.show();
    }
}
