package com.example.demo1.layout;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class InstellingenPaginaLayout {
    public void instellingenPaginaLayout(Pane root){
        Thema(root);
        Taal(root);
    }

    public void Thema(Pane root){
        Button themaButton = new Button("thema");
        themaButton.setLayoutX(50);
        themaButton.setLayoutY(110);
        themaButton.setPrefSize(100,30);
        root.getChildren().add(themaButton);
    }

    public void Taal(Pane root){
        Button taalButton = new Button("taal");
        taalButton.setLayoutX(200);
        taalButton.setLayoutY(110);
        taalButton.setPrefSize(100,30);
        root.getChildren().add(taalButton);
    }
}
