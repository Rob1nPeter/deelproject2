package com.example.demo1.layout;

import com.example.demo1.LoginEnRegistreer.LoginValideren;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.List;
import static com.example.demo1.Logica.RegistratiePaginaLogica.openRegistratiePagina;
import static com.example.demo1.Logica.StartPaginaLogica.openStartPagina;
import static com.example.demo1.LoginEnRegistreer.LoginValideren.loginValideren;


public class InlogPaginaLayout extends Layout{
    public void inlogPaginaLayout(Pane root, Stage stage){
        layoutCirkel(root);
        logina(root,stage);
        List<String> buttonKeys = List.of("registreer");
        maakButton(root, buttonKeys, stage);
        terugKnop(root, stage);
    }

    @Override
    protected void setMethode(Button button, Stage stage, String buttonKey) {

        if (buttonKey.equals("registreer")) {
            button.setOnAction(e -> openRegistratiePagina(stage));
        }
    }

    public void logina(Pane root,Stage stage)
    {
        TextField username = createTextField(translate("gebruikersnaam"), 0);
        TextField password = createTextField(translate("wachtwoord"), 1);

        Button LogIn = new Button(translate("login"));
        LogIn.setLayoutX(350);
        LogIn.setLayoutY(400);
        LogIn.setPrefSize(110,30);
        LogIn.setId("button");

        LogIn.setOnAction(e -> {
            String gebruikersnaam = username.getText();
            String wachtwoord = password.getText();

            loginValideren(gebruikersnaam,wachtwoord,stage);

            username.clear();
            password.clear();
        });

        root.getChildren().add(LogIn);
        root.getChildren().add(username);
        root.getChildren().add(password);
    }




    @Override
    protected EventHandler<ActionEvent> setMethodeTerugKnop(Stage stage) {
        return (e -> openStartPagina(stage));
    }


    @Override
    protected int setLayoutX(int buttonKey) {
        return 350;
    }
    @Override
    protected int setLayoutY(int buttonIndex) {
        return 450 + (buttonIndex * 40);
    }
}
