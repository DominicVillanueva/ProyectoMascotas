package com.dominicavs.proyectomascotas.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dominicavs.proyectomascotas.R;
import com.dominicavs.proyectomascotas.adapters.MascotaAdapter;
import com.dominicavs.proyectomascotas.model.Mascota;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PetsFragment extends Fragment {

    private ArrayList<Mascota> mascotas;
    private MascotaAdapter mascotaAdapter;
    private RecyclerView rvMascotas;

    public PetsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_pets, container, false);
        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(layoutManager);
        iniciarListaMascotas();
        iniciarAdapterMascota();
        // Inflate the layout for this fragment
        return v;
    }

    private void iniciarAdapterMascota() {
        mascotaAdapter = new MascotaAdapter(mascotas, getActivity());
        rvMascotas.setAdapter(mascotaAdapter);
    }

    private void iniciarListaMascotas() {
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota("Luffy", R.drawable.mascota1,6));
        mascotas.add(new Mascota("Draco", R.drawable.mascota2, 5));
        mascotas.add(new Mascota("Neron", R.drawable.mascota3,10 ));
        mascotas.add(new Mascota("Bethoven", R.drawable.mascota4, 4));
        mascotas.add(new Mascota("Firulais", R.drawable.mascota5,8));
    }
}
