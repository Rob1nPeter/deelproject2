package com.example.demo1.layout;

import com.example.demo1.LoginEnRegistreer.LoginValideren;
import com.example.demo1.LoginEnRegistreer.RegistratieValideren;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.List;
import static com.example.demo1.Logica.LoginPaginaLogica.openInlogPagina;
import static java.util.Arrays.asList;


public class RegistratiePaginaLayout extends Layout{

    public void registratiePaginaLayout(Pane root, Stage stage) {
        layoutCirkel(root);
        Register(root, stage);
        terugKnop(root, stage);
    }
    @Override
    protected void setMethode(Button button, Stage stage, String buttonKey) {
        if (buttonKey.equals("registreer")) {
        }
    }

    public void Register(Pane root,Stage stage)
    {
        TextField usernameR = new TextField();
        usernameR.setPromptText(translate("gebruikersnaam"));
        usernameR.setLayoutX(280);
        usernameR.setLayoutY(310);
        usernameR.setPrefSize(250, 30);


        TextField passwordR = new TextField();
        passwordR.setPromptText(translate("wachtwoord"));
        passwordR.setLayoutX(280);
        passwordR.setLayoutY(350);
        passwordR.setPrefSize(250, 30);

        Button Regisratie = new Button(translate("registreer"));
        Regisratie.setLayoutX(350);
        Regisratie.setLayoutY(400);
        Regisratie.setPrefSize(110,30);

        Regisratie.setOnAction(e -> {
            String gebruikersnaam = usernameR.getText();
            String wachtwoord = passwordR.getText();

            RegistratieValideren.registratieValideren(gebruikersnaam, wachtwoord);

            usernameR.clear();
            passwordR.clear();
        });

        root.getChildren().add(Regisratie);
        root.getChildren().add(usernameR);
        root.getChildren().add(passwordR);
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
