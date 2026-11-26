package es.cesur.dam.ejercicioevaluableintegrador20112026;

import es.cesur.dam.ejercicioevaluableintegrador20112026.models.Equipo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        var cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        sessionFactory.inSession(session -> {
            session.createQuery("from Equipo", Equipo.class)
                    .list()
                    .forEach(System.out::println);
        });
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Tabla JavaFX con Hibernate");
        stage.setScene(scene);
        stage.show();
    }
}
