package com.example.demo1.templatemethod;
import com.example.demo1.Thema;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ResourceBundle;

public abstract class TemplateMethod
{
    public void achtergrond(Stage primaryStage, Pane root, Scene scene){

        primaryStage.setTitle(translate(bundleKey()));
        logo(root);
        blueBar(root, scene);
        fade(scene);
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
        blueBar.setId("bar");
        blueBar.setPrefSize(scene.getWidth(), 50);
        blueBar.setLayoutY(100);

        root.getChildren().add(blueBar);
    }

    private void fade(Scene scene) {
        // Fading background
        Color lightBlueColor = Color.SKYBLUE;
        Color whiteColor = Color.WHITE;
        scene.setFill(new javafx.scene.paint.LinearGradient(0, 0, 1, 1, true, javafx.scene.paint.CycleMethod.NO_CYCLE,
                new javafx.scene.paint.Stop(0, lightBlueColor), new javafx.scene.paint.Stop(1, whiteColor)));

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