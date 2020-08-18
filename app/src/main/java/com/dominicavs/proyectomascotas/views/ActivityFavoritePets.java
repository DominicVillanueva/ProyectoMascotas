package com.dominicavs.proyectomascotas.views;

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

import com.dominicavs.proyectomascotas.R;
import com.dominicavs.proyectomascotas.adapters.FavoritePetAdapter;
import com.dominicavs.proyectomascotas.adapters.MascotaAdapter;
import com.dominicavs.proyectomascotas.presenter.IViewPresenter;
import com.dominicavs.proyectomascotas.presenter.ViewPresenter;
import com.dominicavs.proyectomascotas.views.interfaces.IActivityView;
import com.dominicavs.proyectomascotas.model.Mascota;

import java.util.ArrayList;

public class ActivityFavoritePets extends AppCompatActivity implements IActivityView {

    private Toolbar inActionBarFP;
    private TextView tvToolbarTitle;
    private RecyclerView rvFavoritePets;
    private IViewPresenter iViewPresenter;

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

        rvFavoritePets = (RecyclerView) findViewById(R.id.rvFavoritePets);
        iViewPresenter = new ViewPresenter(this, this);
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

    @Override
    public void generateLayout() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvFavoritePets.setLayoutManager(layoutManager);
    }

    @Override
    public FavoritePetAdapter createAdapter(ArrayList<Mascota> mascotas) {
        FavoritePetAdapter favoritePetAdapter = new FavoritePetAdapter(mascotas, this);
        return favoritePetAdapter;
    }

    @Override
    public void initializeAdapter(FavoritePetAdapter favoritePetAdapter) {
        rvFavoritePets.setAdapter(favoritePetAdapter);
    }
}
