package es.cesur.dam.ejercicioevaluableintegrador20112026;

import es.cesur.dam.ejercicioevaluableintegrador20112026.controllers.MainController;
import es.cesur.dam.ejercicioevaluableintegrador20112026.models.Equipo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        var cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        List<Equipo> equipos = sessionFactory.fromSession(session ->
                session.createQuery("from Equipo", Equipo.class).list()
        );

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main-view.fxml"));
        Parent root = fxmlLoader.load();

        MainController controller = fxmlLoader.getController();
        controller.tableView.getItems().setAll(equipos);

        Scene scene = new Scene(root, 600, 400); // Ajustado al tamaño de tu BorderPane
        stage.setTitle("Tabla JavaFX con Hibernate");
        stage.setScene(scene);
        stage.show();
    }
}