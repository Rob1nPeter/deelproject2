package com.example.demo1.layout;

import javafx.scene.layout.Pane;
import java.util.Arrays;
import java.util.List;

public class MenuLayout extends Layout {

    public void menuLayout(Pane root){
        List<String> buttonKeys = Arrays.asList("instellingen", "logUit", "chatbot");
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
