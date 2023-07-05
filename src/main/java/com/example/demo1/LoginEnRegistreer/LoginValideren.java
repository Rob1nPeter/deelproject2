package com.example.demo1.LoginEnRegistreer;

import com.example.demo1.Logica.MenuLogica;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.util.Map;
import static com.example.demo1.LoginEnRegistreer.LoginAccountsLezen.laadAccountsUitBestand;

public class LoginValideren {
    Map<String, String> accounts;
        LoginValideren(){
        accounts = laadAccountsUitBestand();
    }

    public static void loginValideren(String gebruikersnaam, String wachtwoord, Stage stage) {
        Map<String, String> accounts = laadAccountsUitBestand();
        //boolean isSucces = false;
        if (accounts.containsKey(gebruikersnaam) && accounts.get(gebruikersnaam).equals(wachtwoord)) {
            //isSucces = true;
            MenuLogica.openMenu(stage);
        } else {
            showAlert("Ongeldige gebruikersnaam of wachtwoord");

        }
    }



    private static void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Login");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


}
