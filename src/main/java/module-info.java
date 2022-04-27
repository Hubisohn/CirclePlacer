module com.example.kreiswid {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.kreiswid to javafx.fxml;
    exports com.example.kreiswid;
}