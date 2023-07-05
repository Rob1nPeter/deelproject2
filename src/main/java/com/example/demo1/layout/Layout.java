package com.example.demo1.layout;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.List;
import java.util.ResourceBundle;

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
        ResourceBundle bundle = ResourceBundle.getBundle("i18n.messages_NL");
        return bundle.getString(bundleKey);
    }

    public void maakButton(Pane root, List<String> buttonKeys) {
        for (String buttonKey : buttonKeys) {
            Button button = new Button(translate(buttonKey));
            button.setId("button");
            button.setLayoutX(setLayoutX(buttonKeys.indexOf(buttonKey)));
            button.setLayoutY(setLayoutY(buttonKeys.indexOf(buttonKey)));
            button.setPrefSize(110, 30);

            root.getChildren().add(button);
        }
    }

    public void textfield(Pane root, List<String> textfields)
    {
        for(String textFieldKey : textfields){
            TextField textfield = new TextField();
            textfield.setPromptText(translate(textFieldKey));
            textfield.setLayoutX(280);
            textfield.setLayoutY((310 + (textfields.indexOf(textFieldKey) * 40)));
            textfield.setPrefSize(250, 30);
            root.getChildren().add(textfield);
        }
    }

    protected abstract int setLayoutX(int buttonIndex);
    protected abstract int setLayoutY(int buttonIndex);
}
