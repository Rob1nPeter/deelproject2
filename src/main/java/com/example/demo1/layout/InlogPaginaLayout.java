package com.example.demo1.layout;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;


public class InlogPaginaLayout extends Layout{
    public void inlogPaginaLayout(Pane root, Stage stage){
        layoutCirkel(root);
        List<String> textfields = asList("gebruikersnaam", "wachtwoord");
        textfield(root, textfields);
        List<String> buttonKeys = Arrays.asList("login", "registreer");
        maakButton(root, buttonKeys, stage);
        terugKnop(root);
    }

    @Override
    protected void setMethode(Button button, List<String> buttonKeys, Stage stage) {
        for (String buttonKey : buttonKeys) {
            switch (buttonKey){
                case "login": button.setOnAction(e -> openInlogPagina());
                case "registreer": button.setOnAction(e -> openInlogPagina());
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
    protected int setLayoutX(int buttonKey) {
        return 350;
    }
    @Override
    protected int setLayoutY(int buttonIndex) {
        return 450 + (buttonIndex * 40);
    }
}
