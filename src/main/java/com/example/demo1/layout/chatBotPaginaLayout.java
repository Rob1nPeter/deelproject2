package com.example.demo1.layout;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class chatBotPaginaLayout {

    public void chatBotPaginaLayout(Pane root){
        chatGptCirkel(root);
    }

    public void chatGptCirkel(Pane root){
        Circle circle2 = new Circle();
        circle2.setCenterX(614);
        circle2.setCenterY(429);
        circle2.setRadius(335);
        circle2.setFill(Color.DARKBLUE);

        Circle circlewhite2 = new Circle();
        circlewhite2.setCenterX(614);
        circlewhite2.setCenterY(417.8);
        circlewhite2.setRadius(310.2);
        circlewhite2.setFill(Color.WHITE);

        root.getChildren().add(circle2);
        root.getChildren().add(circlewhite2);
    }
}
