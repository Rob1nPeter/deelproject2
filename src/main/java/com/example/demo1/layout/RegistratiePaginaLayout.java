package com.example.demo1.layout;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.List;
import static com.example.demo1.Logica.LoginPaginaLogica.openInlogPagina;
import static java.util.Arrays.asList;


public class RegistratiePaginaLayout extends Layout{

    public void registratiePaginaLayout(Pane root, Stage stage) {
        layoutCirkel(root);
        List<String> textfields = asList("gebruikersnaam", "wachtwoord");
        textfield(root, textfields);
        List<String> buttonKeys = List.of("registreer");
        maakButton(root, buttonKeys, stage);
        terugKnop(root, stage);
    }
    @Override
    protected void setMethode(Button button, Stage stage, String buttonKey) {
        if (buttonKey.equals("registreer")) {
            button.setOnAction(e -> openInlogPagina(stage));
        }
    }
    @Override
    protected EventHandler<ActionEvent> setMethodeTerugKnop(Stage stage) {
        return (e -> openInlogPagina(stage));
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
