package com.example.demo1.templatemethod;
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

        primaryStage.setTitle(translate(bundleKey()));

        Pane root = new Pane();
        Scene scene = new Scene(root, 800, 600);

        logo(root);
        blueBar(root, scene);
        fade(scene);
        displayTitle(root, scene);

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
        String titleText = bundleKey();

        Text title = new Text(titleText);
        title.setFont(Font.font("Oswald", FontWeight.EXTRA_BOLD, 50));
        title.setFill(Color.WHITE);
        title.setStroke(Color.SKYBLUE);
        title.setStrokeWidth(1);
        title.setX((scene.getWidth() - title.getLayoutBounds().getWidth()) / 2);
        title.setY(70);

        root.getChildren().add(title);
    }
}