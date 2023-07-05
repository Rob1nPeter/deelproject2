package com.example.demo1.layout;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.List;

import static com.example.demo1.Logica.LoginLogica.openInlogPagina;


public class StartPaginaLayout extends Layout {
   public void starPaginaLayout(Pane root, Stage stage){
      layoutCirkel(root);
      List<String> buttonKeys = List.of("welkom");
      maakButton(root, buttonKeys, stage);
   }

      @Override
      protected void setMethode(Button button, List<String> buttonKeys, Stage stage) {
         for (String buttonKey : buttonKeys) {
            if (buttonKey.equals("welkom")) {
               button.setOnAction(e -> openInlogPagina(stage));
            }
         }
      }


   public void placeholder(){
      System.out.println("test");
   }
   @Override
   protected EventHandler<ActionEvent> setMethodeTerugKnop() {
      return (e -> placeholder());
   }

   @Override
   protected int setLayoutX(int buttonIndex) {
      return 345;
   }
   @Override
   protected int setLayoutY(int buttonIndex) {
      return 370;
   }
}
