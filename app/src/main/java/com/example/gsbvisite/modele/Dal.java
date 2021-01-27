package com.example.gsbvisite.modele;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
public class Dal {

    //propriétés

    private String dbNom = "GsbDB.sqlite";
    private String version;
    private GsbDb createDb;

    //region Constructeur

    /**
     * Constructeur
     * Crée la DB dans le dispositif.
     * @param context
     */


    public Dal(Context context){
        createDb = new GsbDb(context, dbNom, null, 1);
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
