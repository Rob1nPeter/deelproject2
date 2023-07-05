package com.example.demo1.layout;

import javafx.scene.layout.Pane;
import java.util.List;


public class StartPaginaLayout extends Layout {
   public void starPaginaLayout(Pane root){
      layoutCirkel(root);
      List<String> buttonKeys = List.of("welkom");
      maakButton(root, buttonKeys);
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
