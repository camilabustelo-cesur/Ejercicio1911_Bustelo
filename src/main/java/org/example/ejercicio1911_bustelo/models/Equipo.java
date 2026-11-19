package org.example.ejercicio1911_bustelo.models;


import jakarta.persistence.*;
import lombok.Data;

@Data

@Entity
//Es un objeto que persiste en una base de datos. Lo caracteriza que tenga un identificador único, que es la clave primaria de la tabla.
@Table(name = "Equipo") //Se indica el nombre de la tabla en la base de datos que corresponde a esta entidad.
public class Equipo {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Se genera automáticamente el valor del identificador único por la BBDD. Se debe indicar el tipo de estrategia de generación. En este caso, se utiliza la estrategia de identidad, que permite que la base de datos genere automáticamente un valor único para el identificador.
    private Long id;

    //@Column(name = "nombre", length = 50, nullable = false, unique = true)
    private String nombre;

    //@Column (name = "categoria")
    private String categoria;

    //@Column(name = "disponible")
    private Boolean disponible;
}
