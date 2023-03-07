module com.example.indovinanumero {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.indovinanumero to javafx.fxml;
    exports com.example.indovinanumero;
}