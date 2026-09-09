package com.tuempresa.actividadjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EstudiantesController {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtCarnet;

    @FXML
    private TextField txtCarrera;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextArea txtResultado;


    @FXML
    public void guardarEstudiante(ActionEvent event) {

        if (camposVacios()) {

            mostrarAlerta(
                    Alert.AlertType.WARNING,
                    "Campos vacíos",
                    "Debe completar todos los campos."
            );

            return;
        }

        String informacion =
                "Nombre: " + txtNombre.getText() + "\n" +
                        "Apellido: " + txtApellido.getText() + "\n" +
                        "Carnet: " + txtCarnet.getText() + "\n" +
                        "Carrera: " + txtCarrera.getText() + "\n" +
                        "Edad: " + txtEdad.getText();

        txtResultado.setText(informacion);

        mostrarAlerta(
                Alert.AlertType.INFORMATION,
                "Registro exitoso",
                "Los datos del estudiante fueron registrados correctamente."
        );
    }


    private boolean camposVacios() {

        return txtNombre.getText().trim().isEmpty()
                || txtApellido.getText().trim().isEmpty()
                || txtCarnet.getText().trim().isEmpty()
                || txtCarrera.getText().trim().isEmpty()
                || txtEdad.getText().trim().isEmpty();
    }


    @FXML
    public void limpiarCampos(ActionEvent event) {

        txtNombre.clear();
        txtApellido.clear();
        txtCarnet.clear();
        txtCarrera.clear();
        txtEdad.clear();
        txtResultado.clear();
    }


    private void mostrarAlerta(
            Alert.AlertType tipo,
            String titulo,
            String mensaje) {

        Alert alert = new Alert(tipo);

        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);

        alert.showAndWait();
    }
}