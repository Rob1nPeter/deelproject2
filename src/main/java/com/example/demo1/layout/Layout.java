package com.example.demo1.layout;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.List;
import java.util.ResourceBundle;

import static com.example.demo1.Logica.TaalLogica.baseNaam;
import static com.example.demo1.Logica.TaalLogica.taal;

public abstract class Layout {
    public void layoutCirkel(Pane root) {
        Circle circle2 = new Circle();
        circle2.setCenterX(400);
        circle2.setCenterY(380);
        circle2.setRadius(200);
        circle2.setFill(Color.DARKBLUE);

        Circle circlewhite2 = new Circle();
        circlewhite2.setCenterX(400);
        circlewhite2.setCenterY(388);
        circlewhite2.setRadius(188);
        circlewhite2.setFill(Color.WHITE);

        root.getChildren().add(circle2);
        root.getChildren().add(circlewhite2);
    }
    protected String translate(String bundleKey){
        ResourceBundle bundle = ResourceBundle.getBundle(taal());
        return bundle.getString(bundleKey);
    }

    public void maakButton(Pane root, List<String> buttonKeys, Stage stage) {
        for (String buttonKey : buttonKeys) {
            Button button = new Button(translate(buttonKey));
            button.setId("button");
            button.setLayoutX(setLayoutX(buttonKeys.indexOf(buttonKey)));
            button.setLayoutY(setLayoutY(buttonKeys.indexOf(buttonKey)));
            button.setPrefSize(110, 30);

            setMethode(button, stage, buttonKey);

            root.getChildren().add(button);
        }
    }
    protected abstract void setMethode(Button button, Stage stage, String naam);

    public void terugKnop(Pane root, Stage stage){
        Button button = new Button(translate("terug"));
        button.setId("button");
        button.setLayoutX(690);
        button.setLayoutY(110);
        button.setPrefSize(110, 30);

        button.setOnAction(setMethodeTerugKnop(stage));

        root.getChildren().add(button);
    }
    protected abstract EventHandler<ActionEvent> setMethodeTerugKnop(Stage stage);

    protected abstract int setLayoutX(int buttonIndex);
    protected abstract int setLayoutY(int buttonIndex);

    public void x (TextField textField){
        textField.setLayoutX(280);
    }
    public void y (TextField textField, int index){
        textField.setLayoutY(310 + (40*index));
    }
    public void prefSize(TextField textField){
        textField.setPrefSize(250, 30);
    }
    public TextField createTextField(String promptText, int index) {
        TextField textField = new TextField();
        textField.setPromptText(promptText);
        x(textField);
        y(textField, index);
        prefSize(textField);
        return textField;
    }
}
