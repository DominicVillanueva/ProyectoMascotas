package com.dominicavs.proyectomascotas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.dominicavs.proyectomascotas.adapters.FragmentAdapter;
import com.dominicavs.proyectomascotas.fragments.PetsFragment;
import com.dominicavs.proyectomascotas.fragments.ProfilePetsFragment;
import com.dominicavs.proyectomascotas.views.AboutMeActivity;
import com.dominicavs.proyectomascotas.views.ActivityFavoritPets;
import com.dominicavs.proyectomascotas.views.ContactActivity;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private Toolbar inActionBar;
    private TextView tvToolbarTitle;
    private TabLayout tlPets;
    private ViewPager vpPets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inActionBar = (Toolbar) findViewById(R.id.inActionBar);
        tvToolbarTitle = (TextView) inActionBar.findViewById(R.id.tvToolbarTitle);
        tvToolbarTitle.setText(getResources().getString(R.string.app_name));
        setSupportActionBar(inActionBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        tlPets = (TabLayout) findViewById(R.id.tlPets);
        vpPets = (ViewPager) findViewById(R.id.vpPets);
        setUpViewPager();
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
                Intent iAboutMe = new Intent(MainActivity.this, AboutMeActivity.class);
                startActivity(iAboutMe);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setUpViewPager() {
        vpPets.setAdapter(new FragmentAdapter(getSupportFragmentManager(), addFragments()));
        tlPets.setupWithViewPager(vpPets);
        tlPets.getTabAt(0).setIcon(R.mipmap.ic_home_pet);
        tlPets.getTabAt(1).setIcon(R.mipmap.ic_profile_pet);
    }

    private ArrayList<Fragment> addFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new PetsFragment());
        fragments.add(new ProfilePetsFragment());
        return fragments;
    }
}
