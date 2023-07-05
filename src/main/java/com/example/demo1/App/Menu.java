package com.example.demo1.App;

import com.example.demo1.layout.MenuLayout;
import com.example.demo1.templatemethod.MenuPaginaTemplate;
import com.example.demo1.templatemethod.TemplateMethod;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Menu extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        TemplateMethod test = new MenuPaginaTemplate();
        MenuLayout test2 = new MenuLayout();
        Pane root = new Pane();
        Scene scene = new Scene(root, 800, 600);
        test.achtergrond(stage, root, scene);
        test2.menuLayout(root);
    }

}
