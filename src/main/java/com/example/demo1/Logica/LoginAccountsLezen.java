package com.example.demo1.Logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginAccountsLezen {

    static Map<String, String> laadAccountsUitBestand(){
        //Nieuwe hashmap om accounts op te slaan.
        Map<String, String> loadedAccounts = new HashMap<>();
        //Try and catch voor IOExceptions als er een error is wordt e.printStackTTrace()
        //afgedrukt.
        try {
            //File object dat verwijst naar het text bestand.(Om het natuurlijk af te gaan lezen.)
            File file = new File("accounts.txt");
            //De if statement checkt of het bestand(accounts.txt) bestaat.
            if (file.exists()) {
                //Een buffered gecombineerd met de FileReader reader wordt gemaakt om accounts.txt te lezen
                FileReader fileReader = new FileReader(file);
                BufferedReader reader = new BufferedReader(fileReader);
                //Line slaat een regel op in het bestand.
                String line;
                //Leest het regel voor regel zolang de regel iets bevat.
                while ((line = reader.readLine()) != null) {
                    //Line wordt gesplitst op basis van het : teken.(OMdat in ons txt bestand de data
                    //zo wordt opgeslagen -> gebruikersnaam:wachtwoord
                    String[] parts = line.split(":");
                    //if statement controleert of er twee delen zijn in dit geval username en wachtwoord
                    if (parts.length == 2) {
                        //De gebruikersnaam en wachtwoord worden in de map gezet parts[0] is de sleutel
                        //en parts[1] is de value of waarde. (Gebruikersnaam en wachtwoord)
                        loadedAccounts.put(parts[0], parts[1]);
                    }
                }
                //Buffered reader wordt gesloten
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //retourneerd de map met geladen accounts.
        return loadedAccounts;
    }
}
