package com.dominicavs.proyectomascotas.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.TextView;

import com.dominicavs.proyectomascotas.R;

public class AboutMeActivity extends AppCompatActivity {

    private Toolbar inActionBar;
    private TextView tvToolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
        inActionBar = (Toolbar) findViewById(R.id.inActionBar);
        tvToolbarTitle = (TextView) inActionBar.findViewById(R.id.tvToolbarTitle);
        tvToolbarTitle.setText(getResources().getString(R.string.app_name));
        setSupportActionBar(inActionBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
