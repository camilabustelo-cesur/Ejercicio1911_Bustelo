package org.example.ejercicio1911_bustelo;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.example.ejercicio1911_bustelo.models.Equipo;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController {

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

    public void initialialize(URL location, ResourceBundle resources){
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
    }


}
