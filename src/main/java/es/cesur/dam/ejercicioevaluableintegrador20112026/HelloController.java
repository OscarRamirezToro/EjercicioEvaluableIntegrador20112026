package es.cesur.dam.ejercicioevaluableintegrador20112026;

import es.cesur.dam.ejercicioevaluableintegrador20112026.models.Equipo;
import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn ID;
    @FXML
    private TableColumn Nombre;
    @FXML
    private TableColumn Categoria;
    @FXML
    private TableColumn Disponible;

    public void initialize() {

        ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        Nombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        Categoria.setCellValueFactory(new PropertyValueFactory<>("Categoria"));
        Disponible.setCellValueFactory(new PropertyValueFactory<>("Disponible"));

        ObservableList<Equipo> listaPrueba = FXCollections.observableArrayList(
                new Equipo(1, "ThinkPad", "Portátil", true),
                new Equipo(2, "Lenovo", "Sobremesa", false)
        );

        tableView.setItems(listaPrueba);
    }

}
