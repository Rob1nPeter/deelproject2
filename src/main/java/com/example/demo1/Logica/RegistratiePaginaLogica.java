package com.example.demo1.Logica;

import com.example.demo1.App.RegistratiePagina;
import javafx.stage.Stage;

public abstract class RegistratiePaginaLogica {
    public static void openRegistratiePagina(Stage stage){
        RegistratiePagina registratiePagina = new RegistratiePagina();
        registratiePagina.start(stage);
    }
}
