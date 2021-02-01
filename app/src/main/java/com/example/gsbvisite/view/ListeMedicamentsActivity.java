package com.example.gsbvisite.view;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.gsbvisite.R;
import com.example.gsbvisite.controller.MedicamentController;
import com.example.gsbvisite.modele.Medicament;

import java.util.ArrayList;

public class ListeMedicamentsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lvMedicaments;
    ArrayList<Medicament> medicaments;
    MedicamentController medicamentController;
    private MedicamentController controle;
    private MedicamentListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listemedicaments);

        //Création de l'instance de MedicamentController
        this.medicamentController = MedicamentController.getInstance(getBaseContext());
        //Connexion à la base et stockage des médicaments dans l'arraylist
        medicaments = medicamentController.medicaments();

        //"Récupération" de la listView de l'interface
        lvMedicaments =(ListView)findViewById(R.id.listMedic);
        //Ajout d'un évènement "clic dans la liste"
        lvMedicaments.setOnItemClickListener(this);
        //Création de l'instance de ListAdapter
        //listAdapter = new MedicamentListAdapter(this, medicaments)
        adapter = new MedicamentListAdapter(this, this.medicaments);
        //Remplissage de la liste
        lvMedicaments.setAdapter(adapter);
        gestionClick();
    }


    private void gestionClick() {
        ((ImageButton) this.findViewById(R.id.btnRetourdeMedic)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(ListeMedicamentsActivity.this, "Retour à l'accueil", Toast.LENGTH_SHORT).show();
                Log.d("message", "Clic sur Liste médicament");
                Intent i = new Intent(ListeMedicamentsActivity.this, AccueilActivity.class);
                startActivity(i);
            }
        });
    }
        private void creerList(){
            ArrayList<Medicament> lesmedicaments = controle.medicaments();
            if (lesmedicaments != null){
                ListView listView = (ListView)findViewById(R.id.listMedic);
                adapter = new MedicamentListAdapter(this, lesmedicaments);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(this);
            }

        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i("Medoc", "Position" + String.valueOf(position));
        Medicament medicament = (Medicament)adapter.getItem(position);
        String value = medicament.getMNomCommercial();
        Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(ListeMedicamentsActivity.this, DetailMedicamentActivity.class);
       // intent.putExtra("nom", medicament.getMNomCommercial());
       // intent.putExtra("effet", medicament.getEffet());
       // intent.putExtra("prix", medicament.getMPrixEchant());
            intent.putExtra("medicament", medicament);
        startActivity(intent);
        }


}