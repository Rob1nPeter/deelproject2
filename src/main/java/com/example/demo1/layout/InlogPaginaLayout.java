package com.example.demo1.layout;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.Arrays;
import java.util.List;
import static com.example.demo1.Logica.MenuLogica.openMenu;
import static com.example.demo1.Logica.RegistratiePaginaLogica.openRegistratiePagina;
import static com.example.demo1.Logica.StartPaginaLogica.openStartPagina;
import static java.util.Arrays.asList;


public class InlogPaginaLayout extends Layout{
    public void inlogPaginaLayout(Pane root, Stage stage){
        layoutCirkel(root);
        List<String> textfields = asList("gebruikersnaam", "wachtwoord");
        textfield(root, textfields);
        List<String> buttonKeys = Arrays.asList("login", "registreer");
        maakButton(root, buttonKeys, stage);
        terugKnop(root, stage);
    }

    @Override
    protected void setMethode(Button button, Stage stage, String buttonKey) {

        switch (buttonKey) {
            case "login" -> button.setOnAction(e -> openMenu(stage));
            case "registreer" -> button.setOnAction(e -> openRegistratiePagina(stage));
        }
    }

    @Override
    protected EventHandler<ActionEvent> setMethodeTerugKnop(Stage stage) {
        return (e -> openStartPagina(stage));
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
