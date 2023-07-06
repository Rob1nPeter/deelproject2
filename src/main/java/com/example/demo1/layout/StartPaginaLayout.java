package com.example.demo1.layout;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.List;

import static com.example.demo1.Logica.LoginPaginaLogica.openInlogPagina;


public class StartPaginaLayout extends Layout {
   public void starPaginaLayout(Pane root, Stage stage){
      layoutCirkel(root);
      List<String> buttonKeys = List.of("welkom");
      maakButton(root, buttonKeys, stage);
   }

      @Override
      protected void setMethode(Button button, Stage stage, String buttonKey) {
         if (buttonKey.equals("welkom")) {
            button.setOnAction(e -> openInlogPagina(stage));
         }
      }
   @Override
   protected int setLayoutX(int buttonIndex) {
      return 345;
   }
   @Override
   protected int setLayoutY(int buttonIndex) {
      return 370;
   }
   @Override
   protected EventHandler<ActionEvent> setMethodeTerugKnop(Stage stage) {return null;}
}
