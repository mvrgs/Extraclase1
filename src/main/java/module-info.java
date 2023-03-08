module com.example.extraclase1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.extraclase1 to javafx.fxml;
    exports com.example.extraclase1;
}