package com.example.demo1.layout;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import java.util.List;


public class StartPaginaLayout extends Layout {
   public void starPaginaLayout(Pane root){
      layoutCirkel(root);
      List<String> buttonKeys = List.of("welkom");
      maakButton(root, buttonKeys);
   }

      @Override
      protected void setMethode(Button button, List<String> buttonKeys) {
         for (String buttonKey : buttonKeys) {
            if (buttonKey.equals("welkom")) {
               button.setOnAction(e -> openInlogPagina());
            }
         }
      }
      public void openInlogPagina(){
         System.out.println("CHECK");
      }
   @Override
   protected EventHandler<ActionEvent> setMethodeTerugKnop() {
      return (e -> openInlogPagina());
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
