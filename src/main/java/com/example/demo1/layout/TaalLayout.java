package com.example.demo1.layout;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.List;
import static com.example.demo1.Logica.InstellingenLogica.openInstellingen;
import static com.example.demo1.Logica.ThemaLogica.openThema;


public class TaalLayout extends Layout{
    public void taalLayout(Pane root, Stage stage){
        layoutCirkel(root);
        taalTitel(root);
        List<String> buttonKeys = List.of("thema");
        maakButton(root, buttonKeys, stage);
        nederlandsKnop(root, stage);
        engelsKnop(root, stage);
        terugKnop(root, stage);
    }

    public void nederlandsKnop(Pane root, Stage stage){
        Button button = new Button("nederlands");
        button.setId("button");
        button.setLayoutX(350);
        button.setLayoutY(380);
        button.setPrefSize(110, 30);
        root.getChildren().add(button);
        button.setOnAction(e -> openThema(stage));

    }
    public void engelsKnop(Pane root, Stage stage){
        Button button = new Button("engels");
        button.setId("button");
        button.setLayoutX(350);
        button.setLayoutY(420);
        button.setPrefSize(110, 30);
        root.getChildren().add(button);
        button.setOnAction(e -> openThema(stage));

    }




    @Override
    protected void setMethode(Button button, Stage stage, String buttonKey) {
        if (buttonKey.equals("thema")) {
            button.setOnAction(e -> openThema(stage));
        }
    }

    @Override
    protected EventHandler<ActionEvent> setMethodeTerugKnop(Stage stage) {
        return (actionEvent -> openInstellingen(stage));
    }

    @Override
    protected int setLayoutX(int buttonIndex) {
        return 50 + (buttonIndex * 150);
    }

    @Override
    protected int setLayoutY(int buttonIndex) {
        return 110;
    }
    private void taalTitel(Pane root){
        String titleText = "Taal";

        Text taalTitle = new Text(titleText);
        taalTitle.setFont(Font.font("Oswald", FontWeight.BOLD, 35));
        taalTitle.setFill(Color.DARKBLUE);
        taalTitle.setX(365);
        taalTitle.setY(280);

        root.getChildren().add(taalTitle);
    }
}
