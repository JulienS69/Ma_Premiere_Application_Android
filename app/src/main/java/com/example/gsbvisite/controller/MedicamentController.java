package com.example.gsbvisite.controller;

import android.content.Context;
import com.example.gsbvisite.modele.Medicament;
import com.example.gsbvisite.modele.MedicamentDAO;

import java.util.ArrayList;

public final class MedicamentController {

    private static MedicamentController medicamentController = null;
    private static ArrayList<Medicament>medicaments;

    private MedicamentController(){
        super();
    }

    /**
     * Accesseur
      * @return : une instance unique de MedicamentController (singleton)
     */
    public static final MedicamentController getInstance(Context context){
        if(MedicamentController.medicamentController == null) {
            MedicamentController.medicamentController = new MedicamentController();
            medicaments = new ArrayList<>();
            MedicamentDAO medicamentDAO = new MedicamentDAO(context);
            //medicamentDAO.create();
            medicaments = medicamentDAO.read();

        }
        return MedicamentController.medicamentController;
    }

    /**
     * Trouver un médicament par son indice dans l'arraylist
     * @param index
     * @return le médicament
     */

    public Medicament getMedicament(int index) {
        return medicaments.get(index);
    }

    /**
     * Liste des médicaments
     * @return : l'arraylist de médicaments
     */

    public ArrayList<Medicament> medicaments () {
        return medicaments;
    }
}
