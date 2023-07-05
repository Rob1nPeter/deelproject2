package com.example.demo1.layout;

import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class ChatBotLayout {

    public void chatBotPaginaLayout(Pane root){
        chatGptCirkel(root);
        chatGptInvoerBox(root);
        chatGptUitvoerBox(root);
        chatGptListView(root);
    }

    public void chatGptInvoerBox(Pane root){
        TextField invoer = new TextField();
        invoer.setPromptText("voer uw vraag in aan chatgpt");
        invoer.setLayoutX(25);
        invoer.setLayoutY(530);
        invoer.setPrefSize(230,50);
        root.getChildren().add(invoer);
    }

    public void chatGptListView(Pane root){
        ListView chats = new ListView();
        chats.setLayoutX(25);
        chats.setLayoutY(160);
        chats.setPrefSize(230,360);
        root.getChildren().add(chats);
    }

    public void chatGptUitvoerBox(Pane root){
        TextArea uitvoer = new TextArea();
        uitvoer.setLayoutX(400);
        uitvoer.setLayoutY(200);
        uitvoer.setPrefSize(390,390);
        uitvoer.setStyle("-fx-opacity: 0; -fx-text-fill: black;");
        uitvoer.setEditable(false);
        root.getChildren().add(uitvoer);
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
