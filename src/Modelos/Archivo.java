package Modelos;

import java.time.LocalDateTime;

public class Archivo {
    private String nombreArchivo;
    private String contenido;
    private String extension;
    private LocalDateTime fechas;

    public Archivo(String nombreArchivo, String contenido, String extension) {
        this.nombreArchivo = nombreArchivo;
        this.contenido = contenido;
        this.extension = extension;
        this.fechas = LocalDateTime.now();
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public LocalDateTime getFechas() {
        return fechas;
    }

    public void setFechas(LocalDateTime fechas) {
        this.fechas = fechas;
    }

    
}

