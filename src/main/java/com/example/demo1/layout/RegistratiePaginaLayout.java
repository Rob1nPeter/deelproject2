package com.example.demo1.layout;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class RegistratiePaginaLayout {

    public void registratiePaginaLayout(Pane root){
        registratieCirkel(root);
        gebruikersNaamR(root);
        WachtwoordR(root);
        RegistreerOkButton(root);
    }

    public void gebruikersNaamR(Pane root){
        TextField gebruikersNaamRegistratie = new TextField();
        gebruikersNaamRegistratie.setPromptText("gebruikersnaam");
        gebruikersNaamRegistratie.setLayoutX(280);
        gebruikersNaamRegistratie.setLayoutY(310);
        gebruikersNaamRegistratie.setPrefSize(250, 30);
        root.getChildren().add(gebruikersNaamRegistratie);
    }

    public void WachtwoordR(Pane root){
        TextField wachtwoordRegistratie = new TextField();
        wachtwoordRegistratie.setPromptText("wachtwoord");
        wachtwoordRegistratie.setLayoutX(280);
        wachtwoordRegistratie.setLayoutY(370);
        wachtwoordRegistratie.setPrefSize(250, 30);
        root.getChildren().add(wachtwoordRegistratie);
    }

    public void RegistreerOkButton(Pane root){
        Button RegistreerOkButton = new Button("Registreer ");
        RegistreerOkButton.setLayoutX(360);
        RegistreerOkButton.setLayoutY(430);
        RegistreerOkButton.setPrefSize(100,30);
        root.getChildren().add(RegistreerOkButton);
    }
    public void registratieCirkel(Pane root){
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
