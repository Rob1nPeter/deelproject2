package com.example.demo1;


import javafx.scene.Scene;

import java.io.File;

public abstract class Theme {
    public static boolean darkMode = false;
    public static File f = new File("src/main/resources/Thema/lightmode.css");
    public static File f2 = new File("src/main/resources/Thema/darkmode.css");

    public static void keepTheme(Scene scene) {
        if (!darkMode) {
            scene.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));
        } else {
            scene.getStylesheets().add("file:///" + f2.getAbsolutePath().replace("\\", "/"));
        }
    }

}
