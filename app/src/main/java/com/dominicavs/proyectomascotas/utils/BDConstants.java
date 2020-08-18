package com.dominicavs.proyectomascotas.utils;

public class BDConstants {

    public static final String DB_NAME = "PetShop";
    public static final int DB_VERSION = 1;

    /**
     * @TABLE mascota
     * @ATTRIBUTES id: int,
     *             name: String,
     *             foto: int,
     *             quantity_raiting: int
     * */
    public static final String TB_PET = "mascota";
    public static final String TB_PET_ID = "id";
    public static final String TB_PET_NAME = "name";
    public static final String TB_PET_FOTO = "foto";
    public static final String TB_PET_QUANTITY_RAITING = "quantity_raiting";
}
