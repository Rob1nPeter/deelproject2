package com.example.demo1.layout;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import java.util.Arrays;
import java.util.List;

public class MenuLayout extends Layout {

    public void menuLayout(Pane root){
        List<String> buttonKeys = Arrays.asList("instellingen", "logUit", "chatbot");
        maakButton(root, buttonKeys);
        terugKnop(root);

    }

    @Override
    protected void setMethode(Button button, List<String> buttonKeys) {
        for (String buttonKey : buttonKeys) {
            switch (buttonKey){
                case "instellingen": button.setOnAction(e -> openInlogPagina());
                case "logUit": button.setOnAction(e -> openInlogPagina());
                case "chatbot": button.setOnAction(e -> openInlogPagina());
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
