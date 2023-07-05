package com.example.demo1.Logica;

import com.example.demo1.App.Instellingen;
import javafx.stage.Stage;

public class InstellingenLogica {
    public static void openInstellingen(Stage stage){
        Instellingen instellingen = new Instellingen();
        instellingen.start(stage);
    }
}
