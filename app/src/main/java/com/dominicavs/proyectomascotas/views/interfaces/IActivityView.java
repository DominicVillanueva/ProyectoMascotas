package com.dominicavs.proyectomascotas.views.interfaces;

import com.dominicavs.proyectomascotas.adapters.FavoritePetAdapter;
import com.dominicavs.proyectomascotas.adapters.MascotaAdapter;
import com.dominicavs.proyectomascotas.model.Mascota;

import java.util.ArrayList;

public interface IActivityView {
    void generateLayout();
    FavoritePetAdapter createAdapter(ArrayList<Mascota> mascotas);
    void initializeAdapter(FavoritePetAdapter mascotaAdapter);
}
