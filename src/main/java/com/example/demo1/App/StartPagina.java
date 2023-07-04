package com.example.demo1.App;

import com.example.demo1.layout.StartPaginaLayout;
import com.example.demo1.templatemethod.StartPaginaTemplate;
import com.example.demo1.templatemethod.TemplateMethod;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StartPagina extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage){
        TemplateMethod test = new StartPaginaTemplate();
        StartPaginaLayout test2 = new StartPaginaLayout();

        Pane root = new Pane();
        Scene scene = new Scene(root, 800, 600);

        test.achtergrond(stage, root , scene);


    }
}
