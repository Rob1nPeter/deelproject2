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
import javafx.scene.Scene;

import java.util.List;

import static com.example.demo1.Logica.InstellingenLogica.openInstellingen;
import static com.example.demo1.Logica.TaalLogica.openTaal;
import static com.example.demo1.Logica.ThemaLogica.openThema;

public class ThemaLayout extends Layout{
    public void taalLayout(Pane root, Stage stage){
        layoutCirkel(root);
        themaTitel(root, stage);
        List<String> buttonKeys = List.of("taal");
        maakButton(root, buttonKeys, stage);
        lichteModus(root, stage);
        donkereModus(root,stage);
        terugKnop(root, stage);
    }
    public void lichteModus(Pane root, Stage stage){
        Button button = new Button("licht");
        button.setId("button");
        button.setLayoutX(350);
        button.setLayoutY(380);
        button.setPrefSize(110, 30);
        root.getChildren().add(button);
        button.setOnAction(e -> openThema(stage));

    }
    public void donkereModus(Pane root, Stage stage){
        Button button = new Button("donker");
        button.setId("button");
        button.setLayoutX(350);
        button.setLayoutY(420);
        button.setPrefSize(110, 30);
        root.getChildren().add(button);
        button.setOnAction(e -> openThema(stage));

    }

    @Override
    protected void setMethode(Button button, Stage stage, String buttonKey) {
        if (buttonKey.equals("taal")) {
            button.setOnAction(e -> openTaal(stage));
        }
    }

    @Override
    protected EventHandler<ActionEvent> setMethodeTerugKnop(Stage stage) {
        return (actionEvent -> openInstellingen(stage));
    }

    @Override
    protected int setLayoutX(int buttonIndex) {
        return 50 + ((1+buttonIndex) * 150);
    }

    @Override
    protected int setLayoutY(int buttonIndex) {
        return 110;
    }

    private void themaTitel(Pane root, Stage stage){
        String titleText = "Thema";

        Text themaTitle = new Text(titleText);
        themaTitle.setFont(Font.font("Oswald", FontWeight.BOLD, 35));
        themaTitle.setFill(Color.DARKBLUE);
        themaTitle.setX(340);
        themaTitle.setY(280);

        root.getChildren().add(themaTitle);
    }
}
