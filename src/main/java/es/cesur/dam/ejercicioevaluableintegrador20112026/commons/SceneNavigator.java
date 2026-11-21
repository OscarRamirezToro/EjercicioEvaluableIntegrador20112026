package cesur.dam.inventarioappg1.common;

import es.cesur.dam.ejercicioevaluableintegrador20112026.AppG1;
import es.cesur.dam.ejercicioevaluableintegrador20112026.controllers.DetailsController;
import es.cesur.dam.ejercicioevaluableintegrador20112026.controllers.LoginController;
import es.cesur.dam.ejercicioevaluableintegrador20112026.controllers.MainController;
import es.cesur.dam.ejercicioevaluableintegrador20112026.data.DAO;
import es.cesur.dam.ejercicioevaluableintegrador20112026.data.EquipoJdbcDAO;
import es.cesur.dam.ejercicioevaluableintegrador20112026.models.Equipo;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class SceneNavigator {
    private static Stage stage;
    private static final Map<String, Scene> sceneCache = new HashMap<>();
    private static DAO<Equipo> equipoDAO;
    public static void setDAO(DAO<Equipo> equipoDAO) {
        SceneNavigator.equipoDAO = equipoDAO;
    }

    public static void setStage(Stage stage) {
        SceneNavigator.stage = stage;
    }

    public static void navigateTo(String fxml,String title){
        FXMLLoader fxmlLoader = new FXMLLoader(AppG1.class.getResource("views/"+fxml));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
            stage.setTitle(title);
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void navigateToCache(String fxml, String title) {
        Scene scene = sceneCache.computeIfAbsent(fxml, key -> {
            FXMLLoader fxmlLoader = new FXMLLoader(AppG1.class.getResource("views/" + key));
            try {
                return new Scene(fxmlLoader.load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        stage.setTitle(title);
        stage.setScene(scene);
    }

    public static void navigateToInjection(String fxml, String title) {
        FXMLLoader fxmlLoader = new FXMLLoader(AppG1.class.getResource("views/" + fxml));

        fxmlLoader.setControllerFactory(type -> {
            switch (fxml) {
                case "login-view.fxml":   return new LoginController();
                case "main-view.fxml":    return new MainController( (EquipoJdbcDAO) SceneNavigator.equipoDAO);
                case "details-view.fxml": return new DetailsController( SceneNavigator.equipoDAO);
            }
            throw new IllegalArgumentException("Vista no soportada: " + fxml);
        });

        try {
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle(title);
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}