package com.example.demo1.layout;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class StartPaginaLayout {
    public void inlogbutton(Pane root, Scene scene){
        Button button = new Button("Login button");
        root.getChildren().add(button);
    }
}
