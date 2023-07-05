package com.example.demo1.layout;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.util.ResourceBundle;

public class MenuLayout {

    public void menuLayout(Pane root){
        Settings(root);
        logUit(root);
        Chatgpt(root);
    }

    public void Settings(Pane root){
        Button settingsButton = new Button(translate("instellingen"));
        settingsButton.setLayoutX(50);
        settingsButton.setLayoutY(110);
        settingsButton.setPrefSize(100,30);
        root.getChildren().add(settingsButton);
    }

    public void logUit(Pane root){
        Button logUitButton = new Button(translate("logUit"));
        logUitButton.setLayoutX(350);
        logUitButton.setLayoutY(110);
        logUitButton.setPrefSize(100,30);
        root.getChildren().add(logUitButton);
    }

    public void Chatgpt(Pane root){
        Button chatGPTButton = new Button(translate("chatbot"));
        chatGPTButton.setLayoutX(200);
        chatGPTButton.setLayoutY(110);
        chatGPTButton.setPrefSize(100,30);
        root.getChildren().add(chatGPTButton);
    }
    private String translate(String bundleKey){
        ResourceBundle bundle = ResourceBundle.getBundle("i18n.messages_NL");
        return bundle.getString(bundleKey);
    }
}
