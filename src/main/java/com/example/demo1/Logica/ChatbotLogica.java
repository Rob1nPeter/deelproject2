package com.example.demo1.Logica;

import com.example.demo1.App.Chatbot;
import javafx.stage.Stage;

public abstract class ChatbotLogica {
    public static void openChatbot(Stage stage){
        Chatbot chatbot = new Chatbot();
        chatbot.start(stage);
    }
}
