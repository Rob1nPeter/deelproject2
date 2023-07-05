package com.example.demo1.Logica;

import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.util.Map;
import static com.example.demo1.Logica.LoginAccountsLezen.laadAccountsUitBestand;
import static com.example.demo1.Logica.MenuLogica.openMenu;

public class LoginValideren {
    Map<String, String> accounts;
        LoginValideren(){
        accounts = laadAccountsUitBestand();
    }

    public static boolean loginValideren(String gebruikersnaam, String wachtwoord) {
        Map<String, String> accounts = laadAccountsUitBestand();
        boolean isSucces = false;
        if (accounts.containsKey(gebruikersnaam) && accounts.get(gebruikersnaam).equals(wachtwoord)) {
            isSucces = true;
        } else {
            showAlert("Ongeldige gebruikersnaam of wachtwoord");

        }
        return isSucces;
    }



    private static void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Login");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


}
