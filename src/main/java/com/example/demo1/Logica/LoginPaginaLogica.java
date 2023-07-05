package com.example.demo1.Logica;

import com.example.demo1.App.InlogPagina;
import javafx.stage.Stage;

import java.util.Map;

import static com.example.demo1.Logica.LoginAccountsLezen.laadAccountsUitBestand;

public abstract class LoginPaginaLogica {


    public static void openInlogPagina(Stage stage){
        InlogPagina inlogPagina = new InlogPagina();
        inlogPagina.start(stage);
    }
}