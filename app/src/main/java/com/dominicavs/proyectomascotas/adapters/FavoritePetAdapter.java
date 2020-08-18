package com.dominicavs.proyectomascotas.adapters;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dominicavs.proyectomascotas.R;
import com.dominicavs.proyectomascotas.model.Mascota;
import com.dominicavs.proyectomascotas.services.FavoritePetService;

import java.util.ArrayList;

public class FavoritePetAdapter extends RecyclerView.Adapter<FavoritePetAdapter.FavoritePetAdapterViewHolder>  {

    private ArrayList<Mascota> mascotas;
    private Activity activity;

    public FavoritePetAdapter(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public FavoritePetAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pet, parent, false);
        return new FavoritePetAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FavoritePetAdapterViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.ivFoto.setImageResource(mascota.getFoto());
        holder.tvNombre.setText(mascota.getName());
        holder.tvCantRaiting.setText(String.valueOf(mascota.getQuantity_raiting()));

        holder.ibLikeRaiting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FavoritePetService favoritePetService = new FavoritePetService(activity);
                favoritePetService.updateRaitingPet(mascota);
                holder.tvCantRaiting.setText(favoritePetService.getQuantityRaiting(mascota)+ "");
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    static class FavoritePetAdapterViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivFoto;
        private TextView tvNombre;
        private TextView tvCantRaiting;
        private ImageButton ibLikeRaiting;

        public FavoritePetAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.ivFoto);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            tvCantRaiting = (TextView) itemView.findViewById(R.id.tvCantRaiting);
            ibLikeRaiting = (ImageButton) itemView.findViewById(R.id.ibLikeRaiting);
        }
    }
}
