package com.example.demo1.Logica;

import com.example.demo1.App.StartPagina;
import javafx.stage.Stage;

public abstract class StartPaginaLogica {
    public static void openStartPagina(Stage stage){
        StartPagina startPagina = new StartPagina();
        startPagina.start(stage);
    }
}
