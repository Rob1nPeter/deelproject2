package com.example.demo1.layout;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.util.ResourceBundle;

public class InstellingenLayout {
    public void instellingenLayout(Pane root){
        Thema(root);
        Taal(root);
    }

    public void Thema(Pane root){
        Button themaButton = new Button(translate("thema"));
        themaButton.setLayoutX(50);
        themaButton.setLayoutY(110);
        themaButton.setPrefSize(100,30);
        root.getChildren().add(themaButton);
    }

    public void Taal(Pane root){
        Button taalButton = new Button(translate("taal"));
        taalButton.setLayoutX(200);
        taalButton.setLayoutY(110);
        taalButton.setPrefSize(100,30);
        root.getChildren().add(taalButton);
    }
    private String translate(String bundleKey){
        ResourceBundle bundle = ResourceBundle.getBundle("i18n.messages_NL");
        return bundle.getString(bundleKey);
    }
}
