package com.example.demo1.layout;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import java.util.Arrays;
import java.util.List;

public class InstellingenLayout extends Layout{
    public void instellingenLayout(Pane root){
        List<String> buttonKeys = Arrays.asList("thema", "taal");
        maakButton(root, buttonKeys);
        terugKnop(root);
    }

    @Override
    protected void setMethode(Button button, List<String> buttonKeys) {
        for (String buttonKey : buttonKeys) {
            switch (buttonKey){
                case "thema": button.setOnAction(e -> openInlogPagina());
                case "taal": button.setOnAction(e -> openInlogPagina());
            }
        }
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