package com.example.demo1.layout;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class InlogPaginaLayout {

    public void gebruikersNaam(Pane root, Scene scene){
        TextField gebruikersNaamLogin = new TextField();
        gebruikersNaamLogin.setPromptText("gebruikersnaam");
        gebruikersNaamLogin.setLayoutX(280);
        gebruikersNaamLogin.setLayoutY(310);
        gebruikersNaamLogin.setPrefSize(250, 30);
        root.getChildren().add(gebruikersNaamLogin);
    }

    public void Wachtwoord(Pane root, Scene scene){
        TextField wachtwoordLogin = new TextField();
        wachtwoordLogin.setPromptText("wachtwoord");
        wachtwoordLogin.setLayoutX(280);
        wachtwoordLogin.setLayoutY(370);
        wachtwoordLogin.setPrefSize(250, 30);
        root.getChildren().add(wachtwoordLogin);
    }
    public void loginButton(Pane root, Scene scene){
        Button loginButton = new Button("Login ");
        loginButton.setLayoutX(360);
        loginButton.setLayoutY(450);
        loginButton.setPrefSize(100,25);
        root.getChildren().add(loginButton);
    }

    public void RegistreerButton(Pane root, Scene scene){
        Button RegistreerButton = new Button("Registreer ");
        RegistreerButton.setLayoutX(360);
        RegistreerButton.setLayoutY(480);
        RegistreerButton.setPrefSize(100,25);
        root.getChildren().add(RegistreerButton);
    }

    public void loginCirkel(Pane root, Scene scene){
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
}
