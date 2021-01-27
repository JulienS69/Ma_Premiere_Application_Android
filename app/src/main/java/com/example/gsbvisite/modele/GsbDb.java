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
