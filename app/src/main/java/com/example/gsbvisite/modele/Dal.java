package com.example.gsbvisite.modele;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


public class Dal {

    final GsbDb createDb;

    //propriétés

    //region Constructeur

    /**
     * Constructeur
     * Crée la DB dans le dispositif.
     * @param context
     */


    public Dal(Context context){
        SQLiteDatabase db;
        String dbNom = "GsbDb.sqlite";
        int version = 1;
        createDb = new GsbDb(context, dbNom, null,version);
        db = createDb.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS medicament");
        createDb.onCreate(db);
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
