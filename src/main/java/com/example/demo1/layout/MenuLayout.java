package com.example.demo1.layout;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

import static com.example.demo1.Logica.ChatbotLogica.openChatbot;
import static com.example.demo1.Logica.InstellingenLogica.openInstellingen;
import static com.example.demo1.Logica.LoginPaginaLogica.openInlogPagina;

public class MenuLayout extends Layout {

    public void menuLayout(Pane root, Stage stage){
        List<String> buttonKeys = Arrays.asList("instellingen", "chatbot");
        maakButton(root, buttonKeys, stage);
        terugKnop(root, stage);

    }

    @Override
    protected void setMethode(Button button, Stage stage, String buttonKey) {
        switch (buttonKey) {
            case "chatbot" -> button.setOnAction(e -> openChatbot(stage));
            case "instellingen" -> button.setOnAction(e -> openInstellingen(stage));
        }
    }
    @Override
    protected EventHandler<ActionEvent> setMethodeTerugKnop(Stage stage) {
        return (e -> openInlogPagina(stage));
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
