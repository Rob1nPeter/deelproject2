package com.example.demo1.layout;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import static com.example.demo1.Logica.LoginPaginaLogica.openInlogPagina;
import static com.example.demo1.LoginEnRegistreer.RegistratieValideren.registratieValideren;


public class RegistratiePaginaLayout extends Layout{
    TextField gebruikersnaam;
    TextField wachtwoord;

    public void registratiePaginaLayout(Pane root, Stage stage) {
        layoutCirkel(root);
        Register(root);
        terugKnop(root, stage);
    }
    @Override
    protected void setMethode(Button button, Stage stage, String buttonKey) {
        button.setOnAction(e -> registratieAction(button,gebruikersnaam, wachtwoord));

    }

    public void registratieAction(Button regisratie, TextField usernameR, TextField passwordR ){
        regisratie.setOnAction(e -> {
             String gebruikersnaam = usernameR.getText();
             String wachtwoord = passwordR.getText();
            registratieValideren(gebruikersnaam, wachtwoord);
            usernameR.clear();
            passwordR.clear();
        });
    }

    public void Register(Pane root)
    {
        TextField usernameR = createTextField(translate("gebruikersnaam"), 0);
        TextField passwordR = createTextField(translate("wachtwoord"), 1);

        Button regisratie = new Button(translate("registreer"));
        regisratie.setId("button");
        regisratie.setLayoutX(350);
        regisratie.setLayoutY(400);
        regisratie.setPrefSize(110,30);

        root.getChildren().add(regisratie);
        root.getChildren().add(usernameR);
        root.getChildren().add(passwordR);

        registratieAction(regisratie, usernameR, passwordR);
    }

    @Override
    protected EventHandler<ActionEvent> setMethodeTerugKnop(Stage stage) {
        return (e -> openInlogPagina(stage));
    }
    @Override
    protected int setLayoutX(int buttonIndex) {
        return 350;
    }

    @Override
    protected int setLayoutY(int buttonIndex) {
        return 450 + (buttonIndex * 40);
    }
}
