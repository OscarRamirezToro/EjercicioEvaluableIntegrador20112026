module es.cesur.dam.ejercicioevaluableintegrador20112026 {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires java.sql;

    opens es.cesur.dam.ejercicioevaluableintegrador20112026 to javafx.fxml;
    opens es.cesur.dam.ejercicioevaluableintegrador20112026.models to javafx.base;

    exports es.cesur.dam.ejercicioevaluableintegrador20112026;
    exports es.cesur.dam.ejercicioevaluableintegrador20112026.controllers;
    opens es.cesur.dam.ejercicioevaluableintegrador20112026.controllers to javafx.fxml;
}