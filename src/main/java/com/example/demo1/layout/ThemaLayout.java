package com.example.demo1.layout;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.List;

import static com.example.demo1.Logica.InstellingenLogica.openInstellingen;
import static com.example.demo1.Logica.TaalLogica.openTaal;

public class ThemaLayout extends Layout{
    public void taalLayout(Pane root, Stage stage){
        layoutCirkel(root);
        List<String> buttonKeys = List.of("taal");
        maakButton(root, buttonKeys, stage);
        terugKnop(root, stage);
    }

    @Override
    protected void setMethode(Button button, Stage stage, String buttonKey) {
        if (buttonKey.equals("taal")) {
            button.setOnAction(e -> openTaal(stage));
        }
    }

    @Override
    protected EventHandler<ActionEvent> setMethodeTerugKnop(Stage stage) {
        return (actionEvent -> openInstellingen(stage));
    }

    @Override
    protected int setLayoutX(int buttonIndex) {
        return 50 + ((1+buttonIndex) * 150);
    }

    @Override
    protected int setLayoutY(int buttonIndex) {
        return 110;
    }
}
