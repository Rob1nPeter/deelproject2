package com.example.demo1.layout;

import javafx.scene.control.TextArea;

public class Chat {
    private String chatName;
    private TextArea textArea;
    private String chatContent;

    public Chat(String chatName, TextArea textArea) {
        this.chatName = chatName;
        this.textArea = textArea;
        this.chatContent = "";
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public TextArea getTextArea() {
        return textArea;
    }

    public String getChatContent() {
        return chatContent;
    }

    public void setChatContent(String chatContent) {
        this.chatContent = chatContent;
    }

    @Override
    public String toString() {
        return chatName;
    }
}
