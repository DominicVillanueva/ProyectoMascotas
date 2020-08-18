package com.dominicavs.proyectomascotas.model;

public class Mascota {
    private int id;
    private String name;
    private int foto;
    private int quantity_raiting;

    public Mascota() {
    }

    public Mascota(String name, int foto, int quantity_raiting) {
        this.name = name;
        this.foto = foto;
        this.quantity_raiting = quantity_raiting;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getQuantity_raiting() {
        return quantity_raiting;
    }

    public void setQuantity_raiting(int quantity_raiting) {
        this.quantity_raiting = quantity_raiting;
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", foto=" + foto +
                ", quantity_raiting=" + quantity_raiting +
                '}';
    }
}
