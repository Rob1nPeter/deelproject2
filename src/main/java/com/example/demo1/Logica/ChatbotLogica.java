package com.example.demo1.Logica;

import com.example.demo1.App.Chatbot;
import com.example.demo1.Query.*;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class ChatbotLogica {
    public static void openChatbot(Stage stage){
        Chatbot chatbot = new Chatbot();
        chatbot.start(stage);
    }
}
