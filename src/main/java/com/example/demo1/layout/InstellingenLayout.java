package com.example.demo1.layout;

import javafx.scene.layout.Pane;
import java.util.Arrays;
import java.util.List;

public class InstellingenLayout extends Layout{
    public void instellingenLayout(Pane root){
        List<String> buttonKeys = Arrays.asList("thema", "taal");
        maakButton(root, buttonKeys);

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