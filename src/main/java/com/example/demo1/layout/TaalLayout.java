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
import static com.example.demo1.Logica.TaalLogica.nederlands;
import static com.example.demo1.Logica.ThemaLogica.openThema;


public class TaalLayout extends Layout{
    public void taalLayout(Pane root, Stage stage){
        layoutCirkel(root);
        taalTitel(root);
        List<String> buttonKeys = List.of("thema");
        maakButton(root, buttonKeys, stage);
        nederlandsKnop(root);
        engelsKnop(root);
        terugKnop(root, stage);
    }
    private void maakTaalKnop(Pane root, String bundleKey, boolean nl, int index){
        Button button = new Button(translate(bundleKey));
        button.setId("button");
        x(button);
        y(button, index);
        setPrefSize(button);
        addButton(root, button);
        button.setOnAction(e -> nederlands = nl);

    }
    public void nederlandsKnop(Pane root){
        maakTaalKnop(root, "nederlands", true, 0);
    }
    public void engelsKnop(Pane root){
        maakTaalKnop(root, "engels", false, 1);
    }
    private void x(Button button){
        button.setLayoutX(350);
    }
    private void y(Button button, int index){
        button.setLayoutY(380 + (index * 40));
    }
    private void setPrefSize(Button button){
        button.setPrefSize(110, 30);
    }
    private void addButton(Pane root, Button button){
        root.getChildren().add(button);

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
        return 10 + (buttonIndex * 150);
    }

    @Override
    protected int setLayoutY(int buttonIndex) {
        return 110;
    }
    private void taalTitel(Pane root){
        String titleText = translate("taal");

        Text taalTitle = new Text(titleText);
        taalTitle.setFont(Font.font("Oswald", FontWeight.BOLD, 35));
        taalTitle.setFill(Color.DARKBLUE);
        taalTitle.setX(365);
        taalTitle.setY(280);

        root.getChildren().add(taalTitle);
    }
}
