module org.example.ejercicio1911_bustelo {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;

    requires static lombok;


    opens org.example.ejercicio1911_bustelo to javafx.fxml;
    exports org.example.ejercicio1911_bustelo;
}