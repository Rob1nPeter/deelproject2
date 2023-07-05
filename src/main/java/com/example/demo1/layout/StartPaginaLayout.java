package com.example.demo1.layout;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class StartPaginaLayout {
   public void welkom(Pane root){
    Button welkomButton = new Button("Welkom");
       welkomButton.setLayoutX(360);
       welkomButton.setLayoutY(430);
       welkomButton.setPrefSize(70,30);
       root.getChildren().add(welkomButton);
   }
}
