package com.dominicavs.proyectomascotas.presenter;

import android.content.Context;
import android.content.SharedPreferences;

import com.dominicavs.proyectomascotas.model.Mascota;
import com.dominicavs.proyectomascotas.services.FavoritePetService;
import com.dominicavs.proyectomascotas.views.interfaces.IActivityView;

import java.util.ArrayList;

public class ViewPresenter implements IViewPresenter {

    private IActivityView iActivityView;
    private Context context;
    private ArrayList<Mascota> mascotas;
    private FavoritePetService favoritePetService;

    public ViewPresenter(IActivityView iActivityView, Context context) {
        this.iActivityView = iActivityView;
        this.context = context;
        obtenerMascotasBD();
    }

    @Override
    public void obtenerMascotasBD() {
        favoritePetService = new FavoritePetService(context);
        mascotas = favoritePetService.getPets();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iActivityView.initializeAdapter(iActivityView.createAdapter(mascotas));
        iActivityView.generateLayout();
    }
}
