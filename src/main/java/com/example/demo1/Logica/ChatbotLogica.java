package com.example.demo1.Logica;

import com.example.demo1.App.Chatbot;
import com.example.demo1.Query.*;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class ChatbotLogica {
    static Map<String, TextArea> chatAreas = new HashMap<>();
    public static void openChatbot(Stage stage){
        Chatbot chatbot = new Chatbot();
        chatbot.start(stage);
    }
    public static void nieuwechat(ListView<String> listView){
        String chatName = "Chat " + (int)(10*Math.random());
        //kan niet de TextArea aanpassen
        TextArea chatArea = new TextArea();
        chatArea.setEditable(false);
        //De chat name and chat area blijven staan ook al ga je terug.
        chatAreas.put(chatName, chatArea);

        listView.getItems().add(chatName);
    }
    public static void renameChat(ListView<String> listView){
        String chatName = listView.getSelectionModel().getSelectedItem();

        //Als er een chat geselecteert is dan zal chatname niet nul zijn.
        if (chatName != null) {
            TextInputDialog dialog = new TextInputDialog(chatName);
            dialog.setTitle("Hernoem Chat");
            dialog.setHeaderText(null);
            dialog.setContentText("Voer een nieuwe naam in voor de chat:");
            //
            Optional<String> result = dialog.showAndWait();
            result.ifPresent(newChatName -> {
                TextArea chatArea = chatAreas.remove(chatName);
                chatAreas.put(newChatName, chatArea);
                listView.getItems().set(listView.getSelectionModel().getSelectedIndex(), newChatName);
            });
        }
    }
    public static void sendMessage(TextField invoer, TextArea uitvoer,ListView<String> listView){
        String chatName = listView.getSelectionModel().getSelectedItem();

        if (chatName != null) {
            String message = invoer.getText();
            QueryResolutionStrategy<String, String> stringToStringStrategy = new StringToStringStrategy();
            QueryResolutionForm<String> stringQueryForm = new QueryResolutionForm<>(message);
            QueryResolutionResult<String> stringResolutionResult = stringToStringStrategy.resolve(stringQueryForm);
            String resolvedStringData = stringResolutionResult.getData();
            uitvoer.appendText("U: " + message + "\n");
            invoer.clear();

            uitvoer.appendText(resolvedStringData +"\n");
        }
    }
}
