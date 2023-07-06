package com.example.demo1.layout;

import com.example.demo1.Theme;
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
import static com.example.demo1.Logica.TaalLogica.openTaal;

public class ThemaLayout extends Layout{
    public void taalLayout(Pane root, Stage stage){
        layoutCirkel(root);
        themaTitel(root);
        List<String> buttonKeys = List.of("taal");
        maakButton(root, buttonKeys, stage);
        lichteModusKnop(root);
        donkereModusKnop(root);
        terugKnop(root, stage);
    }

    private void maakThemaKnop(Pane root, String bundleKey, boolean donker, int index){
        Button button = new Button(translate(bundleKey));
        button.setId("button");
        x(button);
        y(button, index);
        setPrefSize(button);
        addButton(root, button);
        button.setOnAction(e -> Theme.darkMode = donker);

    }
    public void lichteModusKnop(Pane root){
        maakThemaKnop(root, "licht", false, 0);
    }
    public void donkereModusKnop(Pane root){
        maakThemaKnop(root, "donker", true, 1);
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
        return 10 + ((1+buttonIndex) * 150);
    }

    @Override
    protected int setLayoutY(int buttonIndex) {
        return 110;
    }

    private void themaTitel(Pane root){
        String titleText = translate("thema");

        Text themaTitle = new Text(titleText);
        themaTitle.setFont(Font.font("Oswald", FontWeight.BOLD, 35));
        themaTitle.setFill(Color.DARKBLUE);
        themaTitle.setX(340);
        themaTitle.setY(280);

        root.getChildren().add(themaTitle);
    }
}
