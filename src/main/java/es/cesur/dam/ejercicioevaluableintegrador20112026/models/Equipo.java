package es.cesur.dam.ejercicioevaluableintegrador20112026.models;

public class Equipo {
    private int id;
    private String nombre;
    private String categoria;
    private boolean disponible;

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Equipo(int id, String nombre, String categoria, boolean disponible) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.disponible = disponible;
    }
}
