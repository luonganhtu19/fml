package com.example.demofxml;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class Main3 extends Application {
    Stage window;
    Scene scene, scene1;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        primaryStage.setTitle("Alert Example");
        // Scene
//        Label label = new Label("Welcome JavaFX");
        Button button = new Button("Close ");
        button.setOnAction(actionEvent -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Alert Information");
            alert.setContentText("choose your option");

            ButtonType buttonTypeYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            ButtonType buttonTypeNo = new ButtonType("No", ButtonBar.ButtonData.NO);
            ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

            alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo,buttonTypeCancel);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get()==buttonTypeYes)
                System.out.println("yes");
            else if (result.get().getButtonData() == ButtonBar.ButtonData.NO)
                System.out.println("no");
            else
                System.out.println("cancel");
            String message = result.get().getText();
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Information");
            alert1.setHeaderText("Notification");
            alert1.setContentText(message);
            alert1.show();
            }
        );
        StackPane layout1 = new StackPane();
        layout1.getChildren().addAll( button);
        scene = new Scene(layout1, 300, 200);
        window.setScene(scene);
        window.show();
    }
}
