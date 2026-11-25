package es.cesur.dam.ejercicioevaluableintegrador20112026.controllers;

import es.cesur.dam.ejercicioevaluableintegrador20112026.models.Equipo;
import javafx.beans.property.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainController {
    @FXML
    public TableView<Equipo> tableView;
    @FXML
    private TableColumn<Equipo, String> ID;
    @FXML
    private TableColumn<Equipo, String> Nombre;
    @FXML
    private TableColumn<Equipo, String> Categoria;
    @FXML
    private TableColumn<Equipo, String> Disponible;

    public void initialize() {

        ID.setCellValueFactory((row) -> {
            Equipo equipo = row.getValue();
            Long id = equipo.getId();
            return new SimpleStringProperty(String.valueOf(id));
        });
        Nombre.setCellValueFactory((row) -> {
            if (row.getValue().getNombre().isBlank()) {
                return new SimpleStringProperty("--");
            } else {
                return new SimpleStringProperty(String.valueOf(row.getValue().getNombre()));
            }
        });
        Categoria.setCellValueFactory((row) ->
            new SimpleStringProperty(String.valueOf(row.getValue().getCategoria()).toUpperCase())
        );
        Disponible.setCellValueFactory((row) -> {
            var availability = row.getValue().getDisponible();
            String output = availability ? "Disponible" : "No disponible";
            return new SimpleStringProperty(output);
        });

    }

}
