package com.example.demo1.layout;

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
import java.util.ResourceBundle;

import static com.example.demo1.Logica.MenuLogica.openMenu;
import static com.example.demo1.Logica.TaalLogica.taal;


public class ChatBotLayout {
    private ListView<Chat> chatList;
    private TextField invoer;
    private final Map<String, TextArea> chatAreas = new HashMap<>();
    private TextArea uitvoer;
    private String currentChatName;

    private final ObservableList<Chat> chats = FXCollections.observableArrayList();

    public void chatBotLayout(Pane root, Stage stage) {
        terugKnop(root, stage);
        chatGptCirkel(root);
        chatGptListView(root);
        chatGptInvoerBox(root);
        aanmakenchat(root);
        hernoemChat(root);
        verwijderChatButton(root);
        stuurMessage(root);
        stuurFile(root);

        chatList.setItems(chats);

        // Toevoegen van een ListChangeListener om de geselecteerde chat bij te houden
        chatList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                currentChatName = newValue.getChatName();
                uitvoer.setText(newValue.getChatContent());
                try {
                    Chat previousChat = findChatByName(oldValue.getChatName());
                    if (previousChat != null) {
                        TextArea previousChatArea = previousChat.getTextArea();
                        previousChatArea.setVisible(false);
                    }
                }catch (Exception ignored) {}

                TextArea currentChatArea = newValue.getTextArea();
                currentChatArea.setVisible(true);
            }
        });
    }
    public void terugKnop(Pane root, Stage stage) {
        Button button = new Button(translate("terug"));
        button.setId("button");
        button.setLayoutX(690);
        button.setLayoutY(110);
        button.setPrefSize(110, 30);

        button.setOnAction(e -> openMenu(stage));

        root.getChildren().add(button);
    }
    public void chatGptListView(Pane root) {
        chatList = new ListView<>();
        chatList.setLayoutX(25);
        chatList.setLayoutY(160);
        chatList.setPrefSize(230, 360);
        root.getChildren().add(chatList);

        // Initialisatie van de uitvoer TextArea
        uitvoer = new TextArea();
        uitvoer.setLayoutX(400);
        uitvoer.setLayoutY(216);
        uitvoer.setPrefSize(355, 500);
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
    public void chatGptInvoerBox(Pane root) {
        invoer = new TextField();
        invoer.setPromptText("Voer uw vraag in aan ChatGPT");
        invoer.setLayoutX(25);
        invoer.setLayoutY(530);
        invoer.setPrefSize(230, 50);
        root.getChildren().add(invoer);
    }
    public void chatGptCirkel(Pane root) {
        Circle circle2 = new Circle();
        circle2.setCenterX(580);
        circle2.setCenterY(429);
        circle2.setRadius(291.58);
        circle2.setFill(Color.DARKBLUE);

        Circle circlewhite2 = new Circle();
        circlewhite2.setCenterX(580);
        circlewhite2.setCenterY(417.8);
        circlewhite2.setRadius(270);
        circlewhite2.setFill(Color.WHITE);

        root.getChildren().add(circle2);
        root.getChildren().add(circlewhite2);
    }

    private void nieuwechat(Pane root) {
        TextInputDialog dialog = new TextInputDialog(translate("nieuwchat"));
        dialog.setTitle(translate("nieuwchat"));
        dialog.setHeaderText(null);
        dialog.setContentText(translate("voernaam"));

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(chatName -> {
            Chat existingChat = findChatByName(chatName);
            if (existingChat != null) {
                chatList.getSelectionModel().select(existingChat);
                return;
            }

            Chat previousChat = findChatByName(currentChatName);
            if (previousChat != null) {
                TextArea previousChatArea = previousChat.getTextArea();
                previousChatArea.setVisible(false);
            }

            TextArea chatArea = new TextArea();
            chatArea.setLayoutX(400);
            chatArea.setLayoutY(216);
            chatArea.setPrefSize(355, 500);
            chatArea.setStyle("-fx-control-inner-background: white; -fx-text-fill: black; -fx-border-color: white");
            chatArea.setEditable(false);

            Chat newChat = new Chat(chatName, chatArea);
            chats.add(newChat); // Voeg de nieuwe chat toe aan de chats-lijst


            chatList.setItems(chats);

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

    public void aanmakenchat(Pane root) {
        Button button = new Button(translate("nieuw"));
        button.setId("button");
        button.setLayoutX(10);
        button.setLayoutY(110);
        button.setPrefSize(110, 30);
        root.getChildren().add(button);
        button.setOnAction(e -> nieuwechat(root));
    }

    public void hernoemChat(Pane root) {
        Button button = new Button(translate("hernoem"));
        button.setId("button");
        button.setLayoutX(160);
        button.setLayoutY(110);
        button.setPrefSize(110, 30);

        root.getChildren().add(button);
        button.setOnAction(e -> renameChat(chatList));
    }

    public void verwijderChatButton(Pane root) {
        Button button = new Button(translate("verwijder"));
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
            chatList.getItems().remove(chat); // Gebruik de remove-methode van chatList.getItems()
            uitvoer.clear();
        }
    }

    public void stuurMessage(Pane root) {
        Button button = new Button(translate("stuur"));
        button.setId("button");
        button.setLayoutX(255);
        button.setLayoutY(550);
        button.setPrefSize(60, 30);

        root.getChildren().add(button);
        button.setOnAction(e -> sendMessage(invoer, chatList));
    }

    public void stuurFile(Pane root) {
        Button button = new Button(translate("foto"));
        button.setId("button");
        button.setLayoutX(460);
        button.setLayoutY(110);
        button.setPrefSize(110, 30);

        root.getChildren().add(button);
        button.setOnAction(e -> sendFile(chatList));
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

    public static void sendFile(ListView<Chat> listView) {
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
    private String translate(String bundleKey){
        ResourceBundle bundle = ResourceBundle.getBundle(taal());
        return bundle.getString(bundleKey);
    }
}
