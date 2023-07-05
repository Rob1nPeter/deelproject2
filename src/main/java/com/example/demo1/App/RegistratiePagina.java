package com.example.demo1.App;

import com.example.demo1.layout.RegistratiePaginaLayout;
import com.example.demo1.templatemethod.RegistratiePaginaTemplate;
import com.example.demo1.templatemethod.TemplateMethod;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class RegistratiePagina extends Application {
    @Override
    public void start(Stage stage) {
        TemplateMethod test = new RegistratiePaginaTemplate();
        RegistratiePaginaLayout test2 = new RegistratiePaginaLayout();
        Pane root = new Pane();
        Scene scene = new Scene(root, 800, 600);
        test.achtergrond(stage, root, scene);
        test2.registratiePaginaLayout(root, stage);


    }
}
