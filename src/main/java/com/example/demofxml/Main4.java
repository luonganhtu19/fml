package com.example.demofxml;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.util.Optional;

public class Main4 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Dialog<Pair<String,String>> dialog = new Dialog<>();
        dialog.setTitle("login dialog");
        dialog.setHeaderText("Sign Up");

        ButtonType loginButtonType = new ButtonType("login", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType,ButtonType.CANCEL);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20,150,10,10));

        TextField userName = new TextField();
        userName.setPromptText("username");
        TextField password = new TextField();
        password.setPromptText("password");

        gridPane.add(new Label("username"), 0 ,0);
        gridPane.add(userName, 0, 1);
        gridPane.add(new Label("password"),1,0);
        gridPane.add(password, 1, 1);

        Node loginButton1 = dialog.getDialogPane().lookupButton(loginButtonType);
        loginButton1.setDisable(true);

        userName.textProperty().addListener((observableValue, oldValue, newValue) -> {
            loginButton1.setDisable(newValue.trim().isEmpty());
        });
        dialog.getDialogPane().setContent(gridPane);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType){
                return new Pair<>(userName.getText(),password.getText());
            }
            return null;
        });
        Optional<Pair<String,String >> result = dialog.showAndWait();
        result.ifPresent(userNamePassword -> {
            System.out.println("Username="+userNamePassword.getKey()+", Password="+userNamePassword.getValue() );
        });
    }
}
