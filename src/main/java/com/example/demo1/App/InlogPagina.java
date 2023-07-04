package com.example.demo1.App;

import com.example.demo1.templatemethod.InlogPaginaTemplate;
import com.example.demo1.templatemethod.TemplateMethod;
import javafx.application.Application;
import javafx.stage.Stage;

public class InlogPagina extends Application {
    @Override
    public void start(Stage stage) {
        TemplateMethod test = new InlogPaginaTemplate();
        test.achtergrond(stage);
    }
}
