module org.example.ejercicio1911_bustelo {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires static lombok;
    requires java.naming;


    opens org.example.ejercicio1911_bustelo;
    opens org.example.ejercicio1911_bustelo.models;
    exports org.example.ejercicio1911_bustelo;
}