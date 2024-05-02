module com.example.cscfinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.cscfinal to javafx.fxml;
    exports com.example.cscfinal;
}