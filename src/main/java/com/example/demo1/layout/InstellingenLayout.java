package com.example.demo1.layout;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

public class InstellingenLayout extends Layout{
    public void instellingenLayout(Pane root, Stage stage){
        List<String> buttonKeys = Arrays.asList("thema", "taal");
        maakButton(root, buttonKeys, stage);
        terugKnop(root);
    }

    @Override
    protected void setMethode(Button button, List<String> buttonKeys, Stage stage) {
        for (String buttonKey : buttonKeys) {
            switch (buttonKey){
                case "thema": button.setOnAction(e -> openInlogPagina());
                case "taal": button.setOnAction(e -> openInlogPagina());
            }
        }
    }
    @Override
    protected EventHandler<ActionEvent> setMethodeTerugKnop() {
        return (e -> openInlogPagina());
    }
    public void openInlogPagina(){
        System.out.println("CHECK");
    }

    @Override
    protected int setLayoutX(int buttonIndex) {
        return 50 + (buttonIndex * 150);
    }

    @Override
    protected int setLayoutY(int buttonIndex) {
        return 110;
    }
}