package com.example.demo1.App;

import com.example.demo1.layout.ThemaLayout;
import com.example.demo1.templatemethod.TemplateMethod;
import com.example.demo1.templatemethod.ThemaTemplate;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Thema extends Application {

    @Override
    public void start(Stage stage) {
        TemplateMethod test = new ThemaTemplate();
        ThemaLayout test2 = new ThemaLayout();

        Pane root = new Pane();
        Scene scene = new Scene(root, 800, 600);

        test.achtergrond(stage, root , scene);
        test2.taalLayout(root, stage);
    }
}
