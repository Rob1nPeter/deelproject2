package com.example.demo1.layout;


import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;


public class InlogPaginaLayout extends Layout{
    public void inlogPaginaLayout(Pane root){
        layoutCirkel(root);
        List<String> textfields = asList("gebruikersnaam", "wachtwoord");
        textfield(root, textfields);
        List<String> buttonKeys = Arrays.asList("login", "registreer");
        maakButton(root, buttonKeys);
        terugKnop(root);
    }

    @Override
    protected void setMethode(Button button, List<String> buttonKeys) {
        for (String buttonKey : buttonKeys) {
            switch (buttonKey){
                case "login": button.setOnAction(e -> openInlogPagina());
                case "registreer": button.setOnAction(e -> openInlogPagina());
            }
        }
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
