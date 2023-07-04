package com.example.demo1.App;

import com.example.demo1.templatemethod.StartPaginaTemplate;
import com.example.demo1.templatemethod.TemplateMethod;
import javafx.application.Application;
import javafx.stage.Stage;

public class StartPagina extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage){
        TemplateMethod test = new StartPaginaTemplate();
        test.achtergrond(stage);

    }
}
