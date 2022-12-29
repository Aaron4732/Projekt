module com.example.battelship {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.battelship to javafx.fxml;
    exports com.example.battelship;
}