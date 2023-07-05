package com.example.demo1.LoginEnRegistreer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class RegistratieAccountsWriten extends RegistratieValideren {

    static void slaAccountsOpNaarBestand() {

        try {
            FileWriter writer = new FileWriter("accounts.txt", true);
            for (Map.Entry<String, String> entry : accounts.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
