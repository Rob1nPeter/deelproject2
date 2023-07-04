package com.example.demo1;


import javafx.scene.Scene;

import java.io.File;
import java.util.Objects;

public abstract class Thema {
    public static boolean darkMode = false;
    static File f = new File("src/main/resources/Thema/lightmode.css");
    static File f2 = new File("src/main/resources/Thema/darkmode.css");
    public static void keepTheme(Scene scene){
        if(!darkMode) {
            scene.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));
        } else {
            scene.getStylesheets().add("file:///" + f2.getAbsolutePath().replace("\\", "/"));
        }
    }
    /*
    public static void changeTheme(Scene scene){
        if (darkMode) {
            scene.getStylesheets().add(Objects.requireNonNull(Thema.class.getResource("darkmode.css")).toExternalForm());
        } else {
            scene.getStylesheets().remove(Objects.requireNonNull(Thema.class.getResource("darkmode.css")).toExternalForm());
        }
    }

     */
}
