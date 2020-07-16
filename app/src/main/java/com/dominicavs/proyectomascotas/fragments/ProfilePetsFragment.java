package com.dominicavs.proyectomascotas.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dominicavs.proyectomascotas.R;
import com.dominicavs.proyectomascotas.adapters.ProfilePetAdapter;
import com.dominicavs.proyectomascotas.model.Mascota;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfilePetsFragment extends Fragment {

    private CircularImageView civPhotoPet;
    private TextView tvNamePet;
    private RecyclerView rvProfilePet;
    private ArrayList<Mascota> mascotas;
    private ProfilePetAdapter profilePetAdapter;

    public ProfilePetsFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_pets, container,false);

        civPhotoPet = (CircularImageView) view.findViewById(R.id.civPhotoPet);
        tvNamePet = (TextView) view.findViewById(R.id.tvNamePet);
        rvProfilePet = (RecyclerView) view.findViewById(R.id.rvProfilePet);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        rvProfilePet.setLayoutManager(gridLayoutManager);
        iniciarListaProfilePets();
        iniciarAdapterProfilePets();
        // Inflate the layout for this fragment
        return view;
    }

    private void iniciarAdapterProfilePets() {
        profilePetAdapter = new ProfilePetAdapter(mascotas, getActivity());
        rvProfilePet.setAdapter(profilePetAdapter);
    }

    private void iniciarListaProfilePets() {
        mascotas = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            mascotas.add(new Mascota("", R.drawable.mypet, i));
        }
    }
}
