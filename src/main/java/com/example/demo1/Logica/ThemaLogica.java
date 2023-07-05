package com.example.demo1.Logica;

import com.example.demo1.App.Thema;
import com.example.demo1.Theme;
import javafx.stage.Stage;



public abstract class ThemaLogica {
    public static void openThema(Stage stage){
        Thema thema = new Thema();
        thema.start(stage);
    }
    public static void lightMode(Stage stage){
        stage.getScene().getStylesheets().remove(Theme.class.getResource("src/main/resources/Thema/darkmode.css"));
        stage.getScene().getStylesheets().add("file:///" + Theme.f.getAbsolutePath().replace("\\", "/"));
        Theme.darkMode = false;
    }
    public static void darkMode(Stage stage){
        stage.getScene().getStylesheets().remove(Theme.class.getResource("src/main/resources/Thema/lightmode.css"));
        stage.getScene().getStylesheets().add("file:///" + Theme.f2.getAbsolutePath().replace("\\", "/"));
        Theme.darkMode = true;
    }
}
