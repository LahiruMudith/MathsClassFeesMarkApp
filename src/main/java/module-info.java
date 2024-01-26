module org.example.mathsapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.mathsapp to javafx.fxml;
    opens org.example.mathsapp.Controllers;
    opens org.example.mathsapp.Controllers.Student;
    opens org.example.mathsapp.TM to javafx.base;

    exports org.example.mathsapp;
    exports org.example.mathsapp.Controllers;

}