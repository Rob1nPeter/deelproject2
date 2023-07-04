package com.example.demo1.App;

import com.example.demo1.layout.InlogPaginaLayout;
import com.example.demo1.templatemethod.InlogPaginaTemplate;
import com.example.demo1.templatemethod.TemplateMethod;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class InlogPagina extends Application {
    @Override
    public void start(Stage stage) {
        TemplateMethod templateMethod = new InlogPaginaTemplate();
        InlogPaginaLayout inlogPaginaLayout = new InlogPaginaLayout();
        Pane root = new Pane();
        Scene scene = new Scene(root, 800, 600);
        templateMethod.achtergrond(stage, root, scene);

        inlogPaginaLayout.inlogPaginaLayout(root);
    }
}
