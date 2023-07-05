package com.example.demo1.Logica;

import com.example.demo1.App.Thema;
import javafx.stage.Stage;

public abstract class ThemaLogica {
    public static void openThema(Stage stage){
        Thema thema = new Thema();
        thema.start(stage);
    }
}
