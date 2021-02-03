package com.example.gsbvisite.modele;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class GsbDb extends SQLiteOpenHelper {

    // Propriétés

     String medicament = "CREATE TABLE medicament ("
             + "depotlegal TEXT PRIMARY KEY,"
             + "nomcommercial TEXT,"
             + "composition TEXT,"
             + "effet TEXT,"
             + "contreindication TEXT,"
             + "prix REAL)";

    String praticien = "CREATE TABLE praticien ("
            + "numero INTEGER PRIMARY KEY,"
            + "nom TEXT,"
            + "prenom TEXT,"
            + "adresse TEXT,"
            + "codepostal TEXT,"
            + "ville TEXT,"
            + "telephone TEXT,"
            + "coefnotoriete INTEGER)";

    String rendezVous = "CREATE TABLE rendezvous ("
            + "numero INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "date TEXT,"
            + "heure TEXT,"
            + "idPraticien INTEGER,"
            + "FOREIGN KEY (idPraticien) REFERENCES praticien(numero) )";


    //region Constructeur

    /**
     *
     * @param context
     * @param name
     * @param factory
     * @param version
     */
    public GsbDb(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    //endregion

    /**
     * Si changement de base de données
     * @param db
     */

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS medicament");
        db.execSQL(medicament);
        db.execSQL("DROP TABLE IF EXISTS praticien");
        db.execSQL(praticien);
        db.execSQL("DROP TABLE IF EXISTS rendezVous");
        db.execSQL(rendezVous);
    }

    /**
     * Si changement de Version
     * @param db
     * @param oldVersion
     * @param newVersion
     */

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
