package com.example.demo1.layout;

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
