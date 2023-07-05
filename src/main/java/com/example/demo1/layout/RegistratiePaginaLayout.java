package com.example.demo1.layout;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import java.util.List;

import static java.util.Arrays.asList;


public class RegistratiePaginaLayout extends Layout{

    public void registratiePaginaLayout(Pane root) {
        layoutCirkel(root);
        List<String> textfields = asList("gebruikersnaam", "wachtwoord");
        textfield(root, textfields);
        List<String> buttonKeys = List.of("registreer");
        maakButton(root, buttonKeys);
        terugKnop(root);
    }
    @Override
    protected void setMethode(Button button, List<String> buttonKeys) {
        for (String buttonKey : buttonKeys) {
            switch (buttonKey){
                case "gebruikersnaam": button.setOnAction(e -> openInlogPagina());
                case "wachtwoord": button.setOnAction(e -> openInlogPagina());
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
        return 350;
    }

    @Override
    protected int setLayoutY(int buttonIndex) {
        return 450 + (buttonIndex * 40);
    }
}
