module com.unimed {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.unimed to javafx.fxml;
    exports com.unimed;
    exports com.unimed.entities;
    opens com.unimed.entities to javafx.fxml;
    opens com.unimed.view to javafx.fxml;
    exports com.unimed.view;
}