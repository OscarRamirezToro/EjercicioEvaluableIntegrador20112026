module es.cesur.dam.ejercicioevaluableintegrador20112026 {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;

    opens es.cesur.dam.ejercicioevaluableintegrador20112026 to javafx.fxml;
    opens es.cesur.dam.ejercicioevaluableintegrador20112026.models to javafx.base;

    exports es.cesur.dam.ejercicioevaluableintegrador20112026;
}