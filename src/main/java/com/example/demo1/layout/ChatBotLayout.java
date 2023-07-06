package com.example.demo1.layout;

import com.example.demo1.Logica.MenuLogica;
import com.example.demo1.Query.*;
import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class ChatBotLayout {
    private ListView<Chat> chatList;
    private TextField invoer;
    private Map<String, TextArea> chatAreas = new HashMap<>();
    private TextArea uitvoer;
    private String currentChatName;

    private ObservableList<Chat> chats = FXCollections.observableArrayList();

    public void chatBotLayout(Pane root, Stage stage) {
        terugKnop(root, stage);
        chatGptCirkel(root);
        chatGptListView(root);
        chatGptInvoerBox(root);
        aanmakenchat(root);
        hernoemChat(root);
        verwijderChat(root);
        stuurMessage(root);
        stuurFile(root);

        chatList.setItems(chats);

        // Toevoegen van een ListChangeListener om de geselecteerde chat bij te houden
        chatList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                currentChatName = newValue.getChatName();
                uitvoer.setText(newValue.getChatContent());

                Chat previousChat = findChatByName(oldValue.getChatName());
                if (previousChat != null) {
                    TextArea previousChatArea = previousChat.getTextArea();
                    previousChatArea.setVisible(false);
                }

                TextArea currentChatArea = newValue.getTextArea();
                currentChatArea.setVisible(true);
            }
        });
    }

    public void chatGptInvoerBox(Pane root) {
        invoer = new TextField();
        invoer.setPromptText("Voer uw vraag in aan ChatGPT");
        invoer.setLayoutX(25);
        invoer.setLayoutY(530);
        invoer.setPrefSize(230, 50);
        root.getChildren().add(invoer);
    }

    public void chatGptListView(Pane root) {
        chatList = new ListView<>();
        chatList.setLayoutX(25);
        chatList.setLayoutY(160);
        chatList.setPrefSize(230, 360);
        root.getChildren().add(chatList);

        // Initialisatie van de uitvoer TextArea
        uitvoer = new TextArea();
        uitvoer.setLayoutX(385);
        uitvoer.setLayoutY(216);
        uitvoer.setPrefSize(390, 500);
        uitvoer.setStyle("-fx-control-inner-background: white; -fx-text-fill: black; -fx-border-color: white");
        uitvoer.setEditable(false);
        root.getChildren().add(uitvoer);

        // Toevoegen van een ListChangeListener om de geselecteerde chat bij te houden
        chatList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                currentChatName = newValue.getChatName();
                uitvoer.setText(newValue.getChatContent());
            }
        });
    }

    private void nieuwechat(Pane root) {
        TextInputDialog dialog = new TextInputDialog("Nieuwe Chat");
        dialog.setTitle("Nieuwe Chat");
        dialog.setHeaderText(null);
        dialog.setContentText("Voer de naam van de nieuwe chat in:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(chatName -> {
            Chat previousChat = findChatByName(currentChatName);
            if (previousChat != null) {
                TextArea previousChatArea = previousChat.getTextArea();
                previousChatArea.setVisible(false);
            }

            TextArea chatArea = new TextArea();
            chatArea.setLayoutX(385);
            chatArea.setLayoutY(216);
            chatArea.setPrefSize(390, 500);
            chatArea.setStyle("-fx-control-inner-background: white; -fx-text-fill: black; -fx-border-color: white");
            chatArea.setEditable(false);

            Chat newChat = new Chat(chatName, chatArea);
            chats.add(newChat);
            chatList.getItems().add(newChat);
            chatList.getSelectionModel().select(newChat);
            root.getChildren().add(chatArea);

            currentChatName = chatName;
        });
    }
    private Chat findChatByName(String chatName) {
        for (Chat chat : chats) {
            if (chat.getChatName().equals(chatName)) {
                return chat;
            }
        }
        return null;
    }

    public void chatGptCirkel(Pane root) {
        Circle circle2 = new Circle();
        circle2.setCenterX(580);
        circle2.setCenterY(429);
        circle2.setRadius(302.38);
        circle2.setFill(Color.DARKBLUE);

        Circle circlewhite2 = new Circle();
        circlewhite2.setCenterX(580);
        circlewhite2.setCenterY(417.8);
        circlewhite2.setRadius(280);
        circlewhite2.setFill(Color.WHITE);

        root.getChildren().add(circle2);
        root.getChildren().add(circlewhite2);
    }

    public void aanmakenchat(Pane root) {
        Button button = new Button("Nieuw");
        button.setId("button");
        button.setLayoutX(10);
        button.setLayoutY(110);
        button.setPrefSize(110, 30);
        root.getChildren().add(button);
        button.setOnAction(e -> nieuwechat(root));
    }

    public void hernoemChat(Pane root) {
        Button button = new Button("Hernoem");
        button.setId("button");
        button.setLayoutX(160);
        button.setLayoutY(110);
        button.setPrefSize(110, 30);

        root.getChildren().add(button);
        button.setOnAction(e -> renameChat(chatList));
    }

    public void verwijderChat(Pane root) {
        Button button = new Button("Verwijder");
        button.setId("button");
        button.setLayoutX(310);
        button.setLayoutY(110);
        button.setPrefSize(110, 30);

        root.getChildren().add(button);
        button.setOnAction(e -> verwijderChat(chatList, root));
    }

    private void verwijderChat(ListView<Chat> listView, Pane root) {
        Chat chat = listView.getSelectionModel().getSelectedItem();

        if (chat != null) {
            TextArea chatArea = chat.getTextArea();
            root.getChildren().remove(chatArea);
            chatAreas.remove(chat.getChatName());
            chats.remove(chat);
            chatList.getItems().remove(chat);
            uitvoer.clear();
        }
    }

    public void terugKnop(Pane root, Stage stage) {
        Button button = new Button("Terug");
        button.setId("button");
        button.setLayoutX(690);
        button.setLayoutY(110);
        button.setPrefSize(110, 30);

        button.setOnAction(e -> MenuLogica.openMenu(stage));

        root.getChildren().add(button);
    }

    public void stuurMessage(Pane root) {
        Button button = new Button("Stuur");
        button.setId("button");
        button.setLayoutX(255);
        button.setLayoutY(550);
        button.setPrefSize(60, 30);

        root.getChildren().add(button);
        button.setOnAction(e -> sendMessage(invoer, chatList));
    }

    public void stuurFile(Pane root) {
        Button button = new Button("Foto");
        button.setId("button");
        button.setLayoutX(460);
        button.setLayoutY(110);
        button.setPrefSize(110, 30);

        root.getChildren().add(button);
        button.setOnAction(e -> sendFile(uitvoer, chatList));
    }

    public void sendMessage(TextField invoer, ListView<Chat> listView) {
        String chatName = currentChatName;

        if (chatName != null) {
            String message = invoer.getText();
            QueryResolutionStrategy<String, String> stringToStringStrategy = new StringToStringStrategy();
            QueryResolutionForm<String> stringQueryForm = new QueryResolutionForm<>(message);
            QueryResolutionResult<String> stringResolutionResult = stringToStringStrategy.resolve(stringQueryForm);
            String resolvedStringData = stringResolutionResult.getData();

            Chat chat = listView.getSelectionModel().getSelectedItem();
            if (chat != null) {
                TextArea chatArea = chat.getTextArea();
                String chatContent = chat.getChatContent();
                chatContent += "U: " + message + "\n";
                chatContent += resolvedStringData + "\n";

                chatArea.setText(chatContent);
                chat.setChatContent(chatContent);

                invoer.clear();
            }
        }
    }

    public static void sendFile(TextArea uitvoer, ListView<Chat> listView) {
        FileChooser fileChooser = new FileChooser();

        Stage window = new Stage();
        File selectedFile = fileChooser.showOpenDialog(window);

        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Foto's", ".jpeg", ".jpg", ".png"));

        if (selectedFile != null) {
            String fileNaam = selectedFile.getName();
            String bestandExtensie = fileNaam.substring(fileNaam.lastIndexOf(".") + 1);

            Chat chat = listView.getSelectionModel().getSelectedItem();

            if (chat != null) {
                String message1 = "Bestand naam: " + fileNaam;
                String message2 = "Bestand extensie: " + bestandExtensie;
                QueryResolutionStrategy<File, String> fileQueryResolutionStrategy = new FileToStringStrategy();
                QueryResolutionForm<File> fileQueryForm = new QueryResolutionForm<>(selectedFile);
                QueryResolutionResult<String> fileResolutionResult = fileQueryResolutionStrategy.resolve(fileQueryForm);
                String resolvedFileData = fileResolutionResult.getData();

                TextArea chatArea = chat.getTextArea();
                String chatContent = chat.getChatContent();
                chatContent += "U: " + message1 + "\n";
                chatContent += "U: " + message2 + "\n";
                chatContent += resolvedFileData + "\n";

                chatArea.setText(chatContent);
                chat.setChatContent(chatContent);
            }
        }
    }

    private void renameChat(ListView<Chat> listView) {
        Chat chat = listView.getSelectionModel().getSelectedItem();

        if (chat != null) {
            TextInputDialog dialog = new TextInputDialog(chat.getChatName());
            dialog.setTitle("Hernoem Chat");
            dialog.setHeaderText(null);
            dialog.setContentText("Voer de nieuwe naam in voor de chat:");

            Optional<String> result = dialog.showAndWait();
            result.ifPresent(newChatName -> {
                chat.setChatName(newChatName);
                listView.refresh();
            });
        }
    }
}
