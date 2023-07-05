package com.example.demo1.Logica;

import javafx.scene.control.Alert;
import java.util.Map;
import static com.example.demo1.Logica.LoginAccountsLezen.laadAccountsUitBestand;

public class LoginValideren {
    Map<String, String> accounts;
        LoginValideren(){
        accounts = laadAccountsUitBestand();
    }

    public boolean loginValideren(String gebruikersnaam, String wachtwoord) {
        Map<String, String> accounts = laadAccountsUitBestand();
        boolean isSucces = false;
        if (accounts.containsKey(gebruikersnaam) && accounts.get(gebruikersnaam).equals(wachtwoord)) {
            isSucces = true;
        } else {
            showAlert("Ongeldige gebruikersnaam of wachtwoord");
            isSucces = false;
        }
        return isSucces;
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Login");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


}
