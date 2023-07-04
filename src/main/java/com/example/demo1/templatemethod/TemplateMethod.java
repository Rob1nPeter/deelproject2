package com.example.demo1.templatemethod;
import com.example.demo1.Thema;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ResourceBundle;

public abstract class TemplateMethod
{
    public void achtergrond(Stage primaryStage){
        Pane root = new Pane();
        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle(translate(bundleKey()));
        logo(root);
        blueBar(root, scene);
        displayTitle(root, scene);
        Thema.keepTheme(scene);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    protected abstract String bundleKey();
    private String translate(String bundleKey){
        ResourceBundle bundle = ResourceBundle.getBundle("i18n.messages_NL");
        return bundle.getString(bundleKey);
    }
    private void logo(Pane root) {
        // Load the logo image using the content path
        String absolutePath = "logo-42-dont-panic.png";
        Image logoImage = new Image(absolutePath);

        // Create an ImageView to display the logo
        ImageView logoImageView = new ImageView(logoImage);
        logoImageView.setPreserveRatio(true);
        logoImageView.setFitWidth(180); // Adjust the width as needed
        logoImageView.setLayoutX(10);
        logoImageView.setLayoutY(10);

        root.getChildren().add(logoImageView);
    }
    private void blueBar(Pane root, Scene scene) {
        // Dark blue bar below the logo
        Pane blueBar = new Pane();
        blueBar.setBackground(new Background(new BackgroundFill(Color.DARKBLUE, null, null)));
        blueBar.setPrefSize(scene.getWidth(), 40);
        blueBar.setLayoutY(100);

        root.getChildren().add(blueBar);
    }
    private void displayTitle(Pane root, Scene scene) {
        String titleText = translate(bundleKey());

        Text title = new Text(titleText);
        title.setFont(Font.font("Oswald", FontWeight.BOLD, 50));
        title.setFill(Color.WHITE);
        title.setStroke(Color.SKYBLUE);
        title.setStrokeWidth(0.5);
        title.setX((scene.getWidth() - title.getLayoutBounds().getWidth()) / 2);
        title.setY(70);

        root.getChildren().add(title);
    }
}