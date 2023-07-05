package com.example.demo1.Logica;

import com.example.demo1.App.Taal;
import javafx.stage.Stage;

public abstract class TaalLogica {
    public static void openTaal(Stage stage){
        Taal taal = new Taal();
        taal.start(stage);
    }
}
