package com.example.demo1.App;

import com.example.demo1.layout.chatBotPaginaLayout;
import com.example.demo1.templatemethod.ChatbotPaginaTemplate;
import com.example.demo1.templatemethod.TemplateMethod;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Chatbot extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        TemplateMethod test = new ChatbotPaginaTemplate();
        chatBotPaginaLayout test2 = new chatBotPaginaLayout();
        Pane root = new Pane();
        Scene scene = new Scene(root, 800, 600);
        test.achtergrond(stage, root, scene);
        test2.chatBotPaginaLayout(root);
    }
}
