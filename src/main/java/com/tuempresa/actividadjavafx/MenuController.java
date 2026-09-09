package com.tuempresa.actividadjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    public BorderPane mainPane;

    public void abrirEstudiantes(ActionEvent event) {

        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("estudiantes.fxml")
            );

            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource())
                    .getScene()
                    .getWindow();

            stage.setScene(new Scene(root));
            stage.setTitle("Registro de Estudiantes");

        } catch (IOException e) {

            mostrarError("No se pudo abrir el registro de estudiantes.");
        }
    }

    public void abrirPeliculas(ActionEvent event) {

        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("peliculas.fxml")
            );

            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource())
                    .getScene()
                    .getWindow();

            stage.setScene(new Scene(root));
            stage.setTitle("Registro de Películas");

        } catch (IOException e) {

            mostrarError("No se pudo abrir el registro de películas.");
        }
    }

    public void mostrarDesarrollador() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Desarrollador");
        alert.setHeaderText("Información del desarrollador");
        alert.setContentText(
                "Nombre: Giselle Penado\n" +
                        "Carrera: Ingeniería en Sistemas de Información\n" +
                        "Actividad Sumativa #1\n" +
                        "JavaFX"
        );

        alert.showAndWait();
    }

    public void mostrarAyuda() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Ayuda");
        alert.setHeaderText("Sistema de Registro");
        alert.setContentText(
                "Utilice el menú Catálogo para acceder " +
                        "al registro de estudiantes o películas."
        );

        alert.showAndWait();
    }


    private void mostrarError(String mensaje) {

        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle("Error");
        alert.setHeaderText("Ha ocurrido un error");
        alert.setContentText(mensaje);

        alert.showAndWait();
    }

    public void mostrarContextMenu(javafx.scene.input.ContextMenuEvent event) {

        ContextMenu contextMenu = new ContextMenu();

        MenuItem estudiantes = new MenuItem("Registro de Estudiantes");
        MenuItem peliculas = new MenuItem("Registro de Películas");
        MenuItem desarrollador = new MenuItem("Desarrollador");

        estudiantes.setOnAction(this::abrirEstudiantes);
        peliculas.setOnAction(this::abrirPeliculas);
        desarrollador.setOnAction(e -> mostrarDesarrollador());

        contextMenu.getItems().addAll(
                estudiantes,
                peliculas,
                desarrollador
        );

        contextMenu.show(
                mainPane,
                event.getScreenX(),
                event.getScreenY()
        );
    }
}