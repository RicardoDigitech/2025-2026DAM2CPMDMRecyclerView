package ricardosornosa.a2025_2026dam2cpmdmrecyclerview.models;

import java.io.Serializable;
import java.time.LocalDate;

public class ToDoModel implements Serializable {
    private String titulo;
    private String contenido;
    private boolean completado;
    private LocalDate fecha;

    public ToDoModel(String titulo, String contenido) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.completado = false;
        this.fecha = LocalDate.now();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "ToDoModel{" +
                "titulo='" + titulo + '\'' +
                ", contenido='" + contenido + '\'' +
                ", completado=" + completado +
                ", fecha=" + fecha +
                '}';
    }
}
