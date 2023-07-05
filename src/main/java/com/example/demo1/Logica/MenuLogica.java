package com.example.demo1.Logica;

import com.example.demo1.App.Menu;
import javafx.stage.Stage;

public abstract class MenuLogica {
    public static void openMenu(Stage stage){
        Menu menu = new Menu();
        menu.start(stage);
    }
}
