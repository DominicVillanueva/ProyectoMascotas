package com.dominicavs.proyectomascotas.model;

public class Mascota {
    private String nombre;
    private int foto;
    private int cantRaiting;

    public Mascota(String nombre, int foto, int cantRaiting) {
        this.nombre = nombre;
        this.foto = foto;
        this.cantRaiting = cantRaiting;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getCantRaiting() {
        return cantRaiting;
    }

    public void setCantRaiting(int cantRaiting) {
        this.cantRaiting = cantRaiting;
    }
}
