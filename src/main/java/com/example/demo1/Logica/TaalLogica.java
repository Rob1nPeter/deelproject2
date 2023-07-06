package com.example.demo1.Logica;

import com.example.demo1.App.Taal;
import javafx.stage.Stage;

public abstract class TaalLogica {
    public static boolean nederlands = true;
    public static String baseNaam = "i18n.messages_NL";
    public static void openTaal(Stage stage){
        Taal taal = new Taal();
        taal.start(stage);
    }

    public static String taal(){
        if (nederlands){
            baseNaam = "i18n.messages_NL";
        }
        else{
            baseNaam = "i18n.messages_EN";
        }
        return baseNaam;
    }
}
