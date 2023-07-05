package com.example.demo1.layout;

import com.example.demo1.LoginEnRegistreer.LoginValideren;
import com.example.demo1.LoginEnRegistreer.RegistratieValideren;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.Arrays;
import java.util.List;

import static com.example.demo1.Logica.LoginPaginaLogica.openInlogPagina;
import static com.example.demo1.Logica.MenuLogica.openMenu;
import static com.example.demo1.Logica.RegistratiePaginaLogica.openRegistratiePagina;
import static com.example.demo1.Logica.StartPaginaLogica.openStartPagina;
import static java.util.Arrays.asList;


public class InlogPaginaLayout extends Layout{
    public void inlogPaginaLayout(Pane root, Stage stage){
        layoutCirkel(root);
        logina(root,stage);
        //List<String> textfields = asList("gebruikersnaam", "wachtwoord");
        //textfield(root, textfields);
        List<String> buttonKeys = Arrays.asList( "registreer");
        maakButton(root, buttonKeys, stage);
        terugKnop(root, stage);
    }

    @Override
    protected void setMethode(Button button, Stage stage, String buttonKey) {

        switch (buttonKey) {

            case "registreer" -> button.setOnAction(e -> openRegistratiePagina(stage));
        }
    }

    public void logina(Pane root,Stage stage)
    {
        TextField username = new TextField();
        username.setPromptText(translate("login"));
        username.setLayoutX(280);
        username.setLayoutY(310);
        username.setPrefSize(250, 30);


        TextField password = new TextField();
        password.setPromptText(translate("wachtwoord"));
        password.setLayoutX(280);
        password.setLayoutY(350);
        password.setPrefSize(250, 30);

        Button LogIn = new Button("LogIn");
        LogIn.setLayoutX(350);
        LogIn.setLayoutY(400);
        LogIn.setPrefSize(110,30);

        LogIn.setOnAction(e -> {
            String gebruikersnaam = username.getText();
            String wachtwoord = password.getText();

            LoginValideren.loginValideren(gebruikersnaam,wachtwoord,stage);

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
