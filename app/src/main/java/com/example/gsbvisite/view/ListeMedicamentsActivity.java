package com.example.gsbvisite.view;

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


    ArrayList<Medicament> lesmedicaments;
    private MedicamentListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listemedicaments);
        gestionClick();
        creerListe();
    }


    private void retourAcceuil() {
        ((ImageButton) findViewById(R.id.btnRetourdeMedic)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
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

    private void creerListe() {
        Intent intent = getIntent();
        lesmedicaments = intent.getParcelableArrayListExtra("lesmedicaments");
            if (lesmedicaments != null) {
                ListView listMedicaments = (ListView) this.findViewById(R.id.listMedic);
                adapter = new MedicamentListAdapter(this, lesmedicaments);
                listMedicaments.setAdapter(adapter);
                listMedicaments.setOnItemClickListener(this);
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