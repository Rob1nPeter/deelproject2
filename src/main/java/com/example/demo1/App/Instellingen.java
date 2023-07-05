package com.example.demo1.App;

import com.example.demo1.layout.InstellingenPaginaLayout;
import com.example.demo1.layout.RegistratiePaginaLayout;
import com.example.demo1.templatemethod.InstellingenPaginaTemplate;
import com.example.demo1.templatemethod.RegistratiePaginaTemplate;
import com.example.demo1.templatemethod.TemplateMethod;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Instellingen extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        TemplateMethod test = new InstellingenPaginaTemplate();
        InstellingenPaginaLayout test2 = new InstellingenPaginaLayout();
        Pane root = new Pane();
        Scene scene = new Scene(root, 800, 600);
        test.achtergrond(stage, root, scene);
        test2.instellingenPaginaLayout(root);
    }
}
