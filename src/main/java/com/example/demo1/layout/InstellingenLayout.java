package com.example.demo1.layout;

import com.example.demo1.Logica.ThemaLogica;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

import static com.example.demo1.Logica.MenuLogica.openMenu;
import static com.example.demo1.Logica.TaalLogica.openTaal;
import static com.example.demo1.Logica.ThemaLogica.openThema;

public class InstellingenLayout extends Layout{
    public void instellingenLayout(Pane root, Stage stage){
        List<String> buttonKeys = Arrays.asList("thema", "taal");
        maakButton(root, buttonKeys, stage);
        terugKnop(root, stage);
    }

    @Override
    protected void setMethode(Button button, Stage stage, String buttonKey) {
        switch (buttonKey) {
            case "thema" -> button.setOnAction(e -> openThema(stage));
            case "taal" -> button.setOnAction(e -> openTaal(stage));
        }
    }
    @Override
    protected EventHandler<ActionEvent> setMethodeTerugKnop(Stage stage) {
        return (e -> openMenu(stage));
    }

    @Override
    protected int setLayoutX(int buttonIndex) {
        return 10 + (buttonIndex * 150);
    }

    @Override
    protected int setLayoutY(int buttonIndex) {
        return 110;
    }
}