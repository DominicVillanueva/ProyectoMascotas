package com.dominicavs.proyectomascotas.services;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.dominicavs.proyectomascotas.R;
import com.dominicavs.proyectomascotas.database.BDPet;
import com.dominicavs.proyectomascotas.model.Mascota;
import com.dominicavs.proyectomascotas.utils.BDConstants;

import java.util.ArrayList;

public class FavoritePetService {

  private Context context;
  private int onlyInsert = 0;

  public FavoritePetService(Context context) {
    this.context = context;
  }

  public ArrayList<Mascota> getPets() {
    BDPet bdPet = new BDPet(context);
    SharedPreferences preferences = context.getSharedPreferences("pOnlyInsert", Context.MODE_PRIVATE);
    if(preferences.getInt("onlyInsert", 0) == 0) {
      insertPet(bdPet);
    }
    return bdPet.getPetsBD();
  }

  public void insertPet(BDPet bdPet) {
    SharedPreferences preferences = context.getSharedPreferences("pOnlyInsert", Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = preferences.edit();
    ContentValues values = new ContentValues();
    ArrayList<Mascota> mascotas = new ArrayList<>();
    mascotas.add(new Mascota("Bethoven", R.drawable.mascota4, 0));
    mascotas.add(new Mascota("Neron", R.drawable.mascota3,0));
    mascotas.add(new Mascota("Luffy", R.drawable.mascota1,0));
    mascotas.add(new Mascota("Firulais", R.drawable.mascota5,0));
    mascotas.add(new Mascota("Draco", R.drawable.mascota2, 0));

    for (Mascota mascota: mascotas) {
      values.put(BDConstants.TB_PET_NAME, mascota.getName());
      values.put(BDConstants.TB_PET_FOTO, mascota.getFoto());
      values.put(BDConstants.TB_PET_QUANTITY_RAITING, mascota.getQuantity_raiting());
      bdPet.insertPetBD(values);
    }
    onlyInsert++;
    editor.putInt("onlyInsert", onlyInsert);
    editor.commit();
  }

  public void updateRaitingPet(Mascota mascota) {
    BDPet bdPet = new BDPet(context);
    ContentValues values = new ContentValues();
    values.put(BDConstants.TB_PET_QUANTITY_RAITING, getQuantityRaiting(mascota) + 1);
    bdPet.updateRaitingPetBD(values, mascota.getId());
  }

  public int getQuantityRaiting(Mascota mascota) {
    BDPet bdPet = new BDPet(context);
    return bdPet.getQuantityRaitingBD(mascota);
  }
}
