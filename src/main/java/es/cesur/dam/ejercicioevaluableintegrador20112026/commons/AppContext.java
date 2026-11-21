package es.cesur.dam.ejercicioevaluableintegrador20112026.commons;

import javafx.collections.*;

public class AppContext {
    private static final AppContext INSTANCE = new AppContext();
    private final ObservableMap<String, Object> datos = FXCollections.observableHashMap();
    private AppContext() {
        datos.addListener((MapChangeListener<String, Object>) change -> {
            System.out.println("Objetos cambiados -> " + change.getKey());
        });
    }

    public static AppContext getInstance() {
        return INSTANCE;
    }

    public ObservableMap<String, Object> getDatos() {
        return datos;
    }

    public Object get(String key) {
        return datos.get(key);
    }

    public void put(String key, Object value) {
        datos.put(key, value);
    }
}