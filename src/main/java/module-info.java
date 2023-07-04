module com.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demo1 to javafx.fxml;
    exports com.example.demo1.templatemethod;
    opens com.example.demo1.templatemethod to javafx.fxml;
    exports com.example.demo1.App;
    opens com.example.demo1.App to javafx.fxml;
}