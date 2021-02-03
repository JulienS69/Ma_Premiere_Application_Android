package com.example.gsbvisite.modele;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


public class Dal {

    private static Dal dal = null;

    //Nom de la base stocké dans le dispositif

    private static GsbDb createDb = null;

    //propriétés

    //region Constructeur


    private Dal(){
        super();
    }


    public static Dal getInstance(Context context) {
        if (Dal.dal == null) {
            Dal.dal = new Dal();
            SQLiteDatabase db;
            String dbNom = "GsbDb.sqlite";
            int version = 1;
            createDb = new GsbDb(context, dbNom, null, version);
            db = createDb.getWritableDatabase();
           // db.execSQL("DROP TABLE IF EXISTS medicament");
           // db.execSQL("DROP TABLE IF EXISTS praticien");
           // db.execSQL("DROP TABLE IF EXISTS rendezVous");
            createDb.onCreate(db);
        }
        return Dal.dal;
    }

    //endregion


    /**
     * Accès à la db créee.
     * @return
     */

    public GsbDb getCreateDb(){
        return createDb;
    }
}
