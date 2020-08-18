package com.dominicavs.proyectomascotas.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dominicavs.proyectomascotas.R;
import com.dominicavs.proyectomascotas.model.Mascota;

import java.util.ArrayList;

public class ProfilePetAdapter extends RecyclerView.Adapter<ProfilePetAdapter.ProfilepPetAdapterViewHolder> {

    private ArrayList<Mascota> profileMascotas;
    private Activity activity;

    public ProfilePetAdapter(ArrayList<Mascota> profileMascotas, Activity activity) {
        this.profileMascotas = profileMascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ProfilepPetAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_profile_pet, parent, false);
        return new ProfilepPetAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfilePetAdapter.ProfilepPetAdapterViewHolder holder, int position) {
        final Mascota profilePet = profileMascotas.get(position);
        holder.ivFotoProfilePet.setImageResource(profilePet.getFoto());
        holder.tvCantRaitingProfilePet.setText(String.valueOf(profilePet.getQuantity_raiting()));
    }

    @Override
    public int getItemCount() {
        return profileMascotas.size();
    }

    static class ProfilepPetAdapterViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivFotoProfilePet;
        private TextView tvCantRaitingProfilePet;

        public ProfilepPetAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFotoProfilePet = (ImageView) itemView.findViewById(R.id.ivFotoProfilePet);
            tvCantRaitingProfilePet = (TextView) itemView.findViewById(R.id.tvCantRaitingProfilePet);
        }
    }
}
