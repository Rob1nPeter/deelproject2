package com.example.demo1.LoginEnRegistreer;

import javafx.scene.control.Alert;

import java.util.HashMap;
import java.util.Map;
import static com.example.demo1.LoginEnRegistreer.LoginAccountsLezen.laadAccountsUitBestand;
import static com.example.demo1.LoginEnRegistreer.RegistratieAccountsWriten.slaAccountsOpNaarBestand;


public class RegistratieValideren {
    public static Map<String, String> accounts;

    RegistratieValideren(){
        accounts = new HashMap<>();
    }

    public void registratieValideren(String gebruikersnaam, String wachtwoord) {
        accounts = laadAccountsUitBestand();
        boolean registratieSuccess;
        if (accounts.containsKey(gebruikersnaam)) {
            showAlert("Gebruikersnaam bestaat al");
        } else {
            accounts.put(gebruikersnaam, wachtwoord);
            slaAccountsOpNaarBestand();
            showAlert("Registratie succesvol");
        }

    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Registratie");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


}
