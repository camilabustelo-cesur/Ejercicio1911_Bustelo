package org.example.ejercicio1911_bustelo;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.example.ejercicio1911_bustelo.models.Equipo;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TableColumn<Equipo,String>  columnaId;
    @FXML
    private TableColumn<Equipo,String>  columnaCategoría;
    @FXML
    private TableView<Equipo> tabla;
    @FXML
    private TableColumn<Equipo,String>  columnaNombre;
    @FXML
    private TableColumn<Equipo,String>  columnaDisponible;

    public void initialize(URL location, ResourceBundle resources){

        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        sessionFactory.inSession( session -> {
            session.createQuery("from Equipo", Equipo.class)
                    .list()
                    .forEach( equipo -> {
                        tabla.getItems().add(equipo);
                    });
        });

        columnaId.setCellValueFactory((row)->{
            Equipo equipo = row.getValue();
            Long id = equipo.getId();
            return new SimpleStringProperty(String.valueOf(id));
        });
        columnaNombre.setCellValueFactory((row)->{
            if(row.getValue().getNombre().isEmpty()){
                return new SimpleStringProperty("--");
            } else  {
                return new SimpleStringProperty(String.valueOf(row.getValue().getNombre()));
            }
        });
        columnaCategoría.setCellValueFactory((row)->{
            if(row.getValue().getCategoria().isEmpty()){
                return new SimpleStringProperty("--");
            } else  {
                return new SimpleStringProperty(String.valueOf(row.getValue().getCategoria()));
            }
        });
        columnaDisponible.setCellValueFactory((row)->{
            if(row.getValue().getDisponible() == null){
                return new SimpleStringProperty("--");
            } else  {
                return new SimpleStringProperty(String.valueOf(row.getValue().getDisponible()));
            }
        });
    }


}
