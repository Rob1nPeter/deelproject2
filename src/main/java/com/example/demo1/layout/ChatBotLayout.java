package com.example.demo1.layout;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import static com.example.demo1.Logica.ChatbotLogica.*;

public class ChatBotLayout {
    private ListView<String> chatList;
    private TextField invoer;
    private TextArea uitvoer;

    public void chatBotLayout(Pane root){
        chatGptCirkel(root);
        chatGptInvoerBox(root);
        chatGptUitvoerBox(root);
        chatGptListView(root);
        aanmakenchat(root);
        hernoemChat(root);
        stuurMessage(root);
        stuurFile(root);
    }

    public void chatGptInvoerBox(Pane root){
        invoer = new TextField();
        invoer.setPromptText("voer uw vraag in aan chatgpt");
        invoer.setLayoutX(25);
        invoer.setLayoutY(530);
        invoer.setPrefSize(230,50);
        root.getChildren().add(invoer);
    }

    public void chatGptListView(Pane root){
        chatList = new ListView<String>();
        chatList.setLayoutX(25);
        chatList.setLayoutY(160);
        chatList.setPrefSize(230,360);
        root.getChildren().add(chatList);
        nieuwechat(chatList);
    }

    public void chatGptUitvoerBox(Pane root){
        uitvoer = new TextArea();
        uitvoer.setLayoutX(400);
        uitvoer.setLayoutY(200);
        uitvoer.setPrefSize(390,390);
        uitvoer.setStyle("-fx-text-fill: black;");
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

    public void aanmakenchat(Pane root){
        Button button = new Button("Nieuw");
        button.setId("button");
        button.setLayoutX(50);
        button.setLayoutY(110);
        button.setPrefSize(110, 30);
        root.getChildren().add(button);
        button.setOnAction( e -> nieuwechat(chatList));
    }
    public void hernoemChat(Pane root){
        Button button = new Button("Hernoem");
        button.setId("button");
        button.setLayoutX(200);
        button.setLayoutY(110);
        button.setPrefSize(110, 30);

        root.getChildren().add(button);
        button.setOnAction(e -> renameChat(chatList));
    }
    public void stuurMessage(Pane root){
        Button button = new Button("Message");
        button.setId("button");
        button.setLayoutX(350);
        button.setLayoutY(110);
        button.setPrefSize(110, 30);

        root.getChildren().add(button);
        button.setOnAction(e -> sendMessage(invoer,uitvoer,chatList));
    }
    public void stuurFile(Pane root){
        Button button = new Button("Foto");
        button.setId("button");
        button.setLayoutX(500);
        button.setLayoutY(110);
        button.setPrefSize(110, 30);

        root.getChildren().add(button);
        button.setOnAction(e -> sendFile(uitvoer,chatList));
    }

}
