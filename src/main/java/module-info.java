module com.tuempresa.actividadjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tuempresa.actividadjavafx to javafx.fxml;
    exports com.tuempresa.actividadjavafx;
}