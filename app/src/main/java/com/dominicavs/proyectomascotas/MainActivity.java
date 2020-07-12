package com.dominicavs.proyectomascotas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.dominicavs.proyectomascotas.adapters.MascotaAdapter;
import com.dominicavs.proyectomascotas.model.Mascota;
import com.dominicavs.proyectomascotas.views.ActivityFavoritPets;
import com.dominicavs.proyectomascotas.views.ContactActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar inActionBar;
    private RecyclerView rvMascotas;
    private TextView tvToolbarTitle;
    private ArrayList<Mascota> mascotas;
    private MascotaAdapter mascotaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inActionBar = (Toolbar) findViewById(R.id.inActionBar);
        tvToolbarTitle = (TextView) inActionBar.findViewById(R.id.tvToolbarTitle);
        tvToolbarTitle.setText(getResources().getString(R.string.app_name));
        setSupportActionBar(inActionBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        rvMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(layoutManager);
        iniciarListaMascotas();
        iniciarAdapterMascota();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.actionbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.iViewFavorite:
                Intent iViewFavorite = new Intent(MainActivity.this, ActivityFavoritPets.class);
                startActivity(iViewFavorite);
                break;
            case R.id.iContact:
                Intent iContact = new Intent(MainActivity.this, ContactActivity.class);
                startActivity(iContact);
                break;
            case R.id.iAboutMe:
                Toast.makeText(this, "Acerca de Mi", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void iniciarAdapterMascota() {
        mascotaAdapter = new MascotaAdapter(mascotas, this);
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
