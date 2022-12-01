module com.unimed {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.opencsv;
    requires java.sql;
    requires spring.security.crypto;

    opens com.unimed to javafx.fxml;
    exports com.unimed;
    exports com.unimed.entities;
    exports com.unimed.view;
    opens com.unimed.view to javafx.fxml;
}