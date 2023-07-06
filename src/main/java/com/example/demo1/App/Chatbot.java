package com.example.demo1.App;

import com.example.demo1.layout.ChatBotLayout;
import com.example.demo1.templatemethod.ChatbotPaginaTemplate;
import com.example.demo1.templatemethod.TemplateMethod;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Chatbot extends Application {

    @Override
    public void start(Stage stage) {
        TemplateMethod test = new ChatbotPaginaTemplate();
        ChatBotLayout test2 = new ChatBotLayout();
        Pane root = new Pane();
        Scene scene = new Scene(root, 800, 600);
        test.achtergrond(stage, root, scene);
        test2.chatBotLayout(root, stage);
    }
}
