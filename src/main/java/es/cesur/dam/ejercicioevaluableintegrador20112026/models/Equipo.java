package es.cesur.dam.ejercicioevaluableintegrador20112026.models;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name="Equipo")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="categoria")
    private String categoria;

    @Column(name="disponible")
    private Boolean disponible;
}