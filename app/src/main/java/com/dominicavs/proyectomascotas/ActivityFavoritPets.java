package com.dominicavs.proyectomascotas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.dominicavs.proyectomascotas.adapters.MascotaAdapter;
import com.dominicavs.proyectomascotas.model.Mascota;

import java.util.ArrayList;

public class ActivityFavoritPets extends AppCompatActivity {

    private Toolbar inActionBarFP;
    private TextView tvToolbarTitle;
    private RecyclerView rvMascotasFP;
    private ArrayList<Mascota> mascotas;
    private MascotaAdapter mascotaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorit_pets);
        inActionBarFP = (Toolbar) findViewById(R.id.inActionBarFP);
        tvToolbarTitle = (TextView) inActionBarFP.findViewById(R.id.tvToolbarTitle);
        tvToolbarTitle.setText(getResources().getString(R.string.app_name));
        setSupportActionBar(inActionBarFP);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvMascotasFP = (RecyclerView) findViewById(R.id.rvMascotasFP);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotasFP.setLayoutManager(layoutManager);

        iniciarListaMascotas();
        iniciarAdapterMascota();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.actionbar_default_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.optionsFP:
                Toast.makeText(this, "OPCIONES", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void iniciarListaMascotas() {
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota("Bethoven", R.drawable.mascota4, 4));
        mascotas.add(new Mascota("Neron", R.drawable.mascota3,10 ));
        mascotas.add(new Mascota("Luffy", R.drawable.mascota1,6));
        mascotas.add(new Mascota("Firulais", R.drawable.mascota5,8));
        mascotas.add(new Mascota("Draco", R.drawable.mascota2, 5));
    }

    private void iniciarAdapterMascota() {
        mascotaAdapter = new MascotaAdapter(mascotas, this);
        rvMascotasFP.setAdapter(mascotaAdapter);
    }
}
