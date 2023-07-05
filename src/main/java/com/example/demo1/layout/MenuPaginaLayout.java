package com.example.demo1.layout;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class MenuPaginaLayout {

    public void menuPaginaLayout(Pane root){
        Settings(root);
        logUit(root);
        Chatgpt(root);
    }

    public void Settings(Pane root){
        Button settingsButton = new Button("settings ");
        settingsButton.setLayoutX(50);
        settingsButton.setLayoutY(110);
        settingsButton.setPrefSize(100,30);
        root.getChildren().add(settingsButton);
    }

    public void logUit(Pane root){
        Button logUitButton = new Button("logUit ");
        logUitButton.setLayoutX(350);
        logUitButton.setLayoutY(110);
        logUitButton.setPrefSize(100,30);
        root.getChildren().add(logUitButton);
    }

    public void Chatgpt(Pane root){
        Button chatGPTButton = new Button("chatGPT ");
        chatGPTButton.setLayoutX(200);
        chatGPTButton.setLayoutY(110);
        chatGPTButton.setPrefSize(100,30);
        root.getChildren().add(chatGPTButton);
    }
}
