package com.tuempresa.actividadjavafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PeliculasController {

    @FXML
    private TextField txtTitulo;

    @FXML
    private TextField txtDirector;

    @FXML
    private TextField txtGenero;

    @FXML
    private TextField txtAnio;

    @FXML
    private TextField txtDuracion;


    @FXML
    private TableView<Pelicula> tablaPeliculas;

    @FXML
    private TableColumn<Pelicula, String> colTitulo;

    @FXML
    private TableColumn<Pelicula, String> colDirector;

    @FXML
    private TableColumn<Pelicula, String> colGenero;

    @FXML
    private TableColumn<Pelicula, String> colAnio;

    @FXML
    private TableColumn<Pelicula, String> colDuracion;


    private final ObservableList<Pelicula> listaPeliculas =
            FXCollections.observableArrayList();


    @FXML
    public void initialize() {

        configurarColumnas();
        cargarPeliculas();

        tablaPeliculas.getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (observable, peliculaAnterior, peliculaSeleccionada) -> {

                            if (peliculaSeleccionada != null) {

                                cargarDatosEnCampos(
                                        peliculaSeleccionada
                                );
                            }
                        }
                );
    }


    private void configurarColumnas() {

        colTitulo.setCellValueFactory(
                new PropertyValueFactory<>("titulo")
        );

        colDirector.setCellValueFactory(
                new PropertyValueFactory<>("director")
        );

        colGenero.setCellValueFactory(
                new PropertyValueFactory<>("genero")
        );

        colAnio.setCellValueFactory(
                new PropertyValueFactory<>("anio")
        );

        colDuracion.setCellValueFactory(
                new PropertyValueFactory<>("duracion")
        );
    }


    private void cargarPeliculas() {

        listaPeliculas.addAll(

                new Pelicula(
                        "Interestelar",
                        "Christopher Nolan",
                        "Ciencia ficción",
                        "2014",
                        "169 min"
                ),

                new Pelicula(
                        "Titanic",
                        "James Cameron",
                        "Romance",
                        "1997",
                        "195 min"
                ),

                new Pelicula(
                        "Avengers: Endgame",
                        "Anthony Russo",
                        "Acción",
                        "2019",
                        "181 min"
                ),

                new Pelicula(
                        "Toy Story",
                        "John Lasseter",
                        "Animación",
                        "1995",
                        "81 min"
                ),

                new Pelicula(
                        "The Batman",
                        "Matt Reeves",
                        "Acción",
                        "2022",
                        "176 min"
                )
        );

        tablaPeliculas.setItems(listaPeliculas);
    }


    private void cargarDatosEnCampos(Pelicula pelicula) {

        txtTitulo.setText(pelicula.getTitulo());
        txtDirector.setText(pelicula.getDirector());
        txtGenero.setText(pelicula.getGenero());
        txtAnio.setText(pelicula.getAnio());
        txtDuracion.setText(pelicula.getDuracion());
    }


    @FXML
    public void limpiarCampos(ActionEvent event) {

        txtTitulo.clear();
        txtDirector.clear();
        txtGenero.clear();
        txtAnio.clear();
        txtDuracion.clear();

        tablaPeliculas.getSelectionModel().clearSelection();
    }


    @FXML
    public void procesarInformacion(ActionEvent event) {

        if (camposVacios()) {

            mostrarAlerta(
                    Alert.AlertType.WARNING,
                    "Campos vacíos",
                    "Debe completar todos los campos."
            );

            return;
        }

        String mensaje =
                "Información de la película:\n\n" +
                        "Título: " + txtTitulo.getText() + "\n" +
                        "Director: " + txtDirector.getText() + "\n" +
                        "Género: " + txtGenero.getText() + "\n" +
                        "Año: " + txtAnio.getText() + "\n" +
                        "Duración: " + txtDuracion.getText();

        mostrarAlerta(
                Alert.AlertType.INFORMATION,
                "Registro de película",
                mensaje
        );
    }


    private boolean camposVacios() {

        return txtTitulo.getText().trim().isEmpty()
                || txtDirector.getText().trim().isEmpty()
                || txtGenero.getText().trim().isEmpty()
                || txtAnio.getText().trim().isEmpty()
                || txtDuracion.getText().trim().isEmpty();
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