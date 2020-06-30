package com.dominicavs.proyectomascotas.adapters;

import android.app.Activity;
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

import java.util.ArrayList;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaAdapterViewHolder> {

    private ArrayList<Mascota> mascotas;
    private Activity activity;

    public MascotaAdapter(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pet, parent, false);
        return new MascotaAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaAdapterViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.ivFoto.setImageResource(mascota.getFoto());
        holder.tvNombre.setText(mascota.getNombre());
        holder.tvCantRaiting.setText(String.valueOf(mascota.getCantRaiting()));

        holder.ibLikeRaiting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "LIKE", Toast.LENGTH_SHORT).show();
                holder.tvCantRaiting.setText(String.valueOf(mascota.getCantRaiting() + 1));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    static class MascotaAdapterViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivFoto;
        private TextView tvNombre;
        private TextView tvCantRaiting;
        private ImageButton ibLikeRaiting;

        MascotaAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.ivFoto);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            tvCantRaiting = (TextView) itemView.findViewById(R.id.tvCantRaiting);
            ibLikeRaiting = (ImageButton) itemView.findViewById(R.id.ibLikeRaiting);
        }
    }
}
