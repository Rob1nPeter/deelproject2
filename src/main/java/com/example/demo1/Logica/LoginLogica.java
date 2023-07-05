package com.example.demo1.Logica;

import com.example.demo1.App.InlogPagina;
import javafx.stage.Stage;

public abstract class LoginLogica {
    public static void openInlogPagina(Stage stage){
        InlogPagina inlogPagina = new InlogPagina();
        inlogPagina.start(stage);
    }

}
