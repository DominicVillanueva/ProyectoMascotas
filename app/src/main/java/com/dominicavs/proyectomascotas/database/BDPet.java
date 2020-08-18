package com.dominicavs.proyectomascotas.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.dominicavs.proyectomascotas.model.Mascota;
import com.dominicavs.proyectomascotas.utils.BDConstants;

import java.util.ArrayList;

public class BDPet extends SQLiteOpenHelper {

  private Context context;
  public BDPet(@Nullable Context context) {
    super(context, BDConstants.DB_NAME, null, BDConstants.DB_VERSION);
    this.context = context;
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    String queryCreateTBPet = "CREATE TABLE " + BDConstants.TB_PET + "(" +
            BDConstants.TB_PET_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            BDConstants.TB_PET_NAME + " TEXT, " +
            BDConstants.TB_PET_FOTO + " INTEGER, " +
            BDConstants.TB_PET_QUANTITY_RAITING + " INTEGER " + ")";

    db.execSQL(queryCreateTBPet);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS " + BDConstants.TB_PET);
    onCreate(db);
  }

  public ArrayList<Mascota> getPetsBD() {
    ArrayList<Mascota> mascotas = new ArrayList<>();
    String query = "SELECT * FROM " + BDConstants.TB_PET;
    SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    Cursor cursor = sqLiteDatabase.rawQuery(query, null);

    while (cursor.moveToNext()) {
      Mascota mascota = new Mascota();
      mascota.setId(cursor.getInt(0));
      mascota.setName(cursor.getString(1));
      mascota.setFoto(cursor.getInt(2));
      mascota.setQuantity_raiting(cursor.getInt(3));

      mascotas.add(mascota);
    }
    sqLiteDatabase.close();
    return mascotas;
  }

  public void insertPetBD(ContentValues values) {
    SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    sqLiteDatabase.insert(BDConstants.TB_PET, null, values);
    sqLiteDatabase.close();
  }

  public void updateRaitingPetBD(ContentValues values, int id) {
    SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    sqLiteDatabase.update(BDConstants.TB_PET, values, "id="+id, null);

  }

  public int getQuantityRaitingBD(Mascota mascota) {
    int like = 0;
    String query = "SELECT " + BDConstants.TB_PET_QUANTITY_RAITING +
                    " FROM " + BDConstants.TB_PET +
                    " WHERE " + BDConstants.TB_PET_ID + "=" + mascota.getId();

    SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    Cursor cursor = sqLiteDatabase.rawQuery(query, null);

    if(cursor.moveToNext()) {
      like = cursor.getInt(0);
    }

    sqLiteDatabase.close();
    return like;
  }
}
