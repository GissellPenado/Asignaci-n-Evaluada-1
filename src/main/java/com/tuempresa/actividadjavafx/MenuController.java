package com.tuempresa.actividadjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.input.ContextMenuEvent;

import java.io.IOException;

public class MenuController {

    @FXML
    private BorderPane mainPane;

    @FXML
    public void abrirEstudiantes(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("estudiantes.fxml")
            );

            Parent root = loader.load();

            // Obtenemos la ventana desde el BorderPane,
            // NO desde el MenuItem
            Stage stage = (Stage) mainPane.getScene().getWindow();

            stage.setScene(new Scene(root));
            stage.setTitle("Registro de Estudiantes");

        } catch (IOException e) {
            e.printStackTrace();

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No se pudo abrir Registro de Estudiantes");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    public void abrirPeliculas(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("peliculas.fxml")
            );

            Parent root = loader.load();

            // Igual que arriba: usamos mainPane
            Stage stage = (Stage) mainPane.getScene().getWindow();

            stage.setScene(new Scene(root));
            stage.setTitle("Registro de Películas");

        } catch (IOException e) {
            e.printStackTrace();

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No se pudo abrir Registro de Películas");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    public void mostrarDesarrollador() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Desarrollador");
        alert.setHeaderText("Información del desarrollador");
        alert.setContentText(
                "Nombre: Giselle Penado\n" +
                        "Carrera: Ingeniería en Sistemas de Información\n" +
                        "Universidad: UAM"
        );

        alert.showAndWait();
    }

    @FXML
    public void mostrarAyuda() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Ayuda");
        alert.setHeaderText("Sistema de Registro");
        alert.setContentText(
                "Utilice el menú Catálogo para acceder " +
                        "al registro de estudiantes y películas."
        );

        alert.showAndWait();
    }

    @FXML
    public void mostrarContextMenu(ContextMenuEvent event) {

        ContextMenu contextMenu = new ContextMenu();

        MenuItem estudiantes =
                new MenuItem("Registro de Estudiantes");

        MenuItem peliculas =
                new MenuItem("Registro de Películas");

        MenuItem desarrollador =
                new MenuItem("Información del desarrollador");

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