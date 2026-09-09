package com.tuempresa.actividadjavafx;

public class Pelicula {

    private String titulo;
    private String director;
    private String genero;
    private String anio;
    private String duracion;

    public Pelicula(String titulo, String director, String genero,
                    String anio, String duracion) {

        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
        this.anio = anio;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDirector() {
        return director;
    }

    public String getGenero() {
        return genero;
    }

    public String getAnio() {
        return anio;
    }

    public String getDuracion() {
        return duracion;
    }
}