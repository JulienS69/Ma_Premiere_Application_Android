package com.example.gsbvisite.view;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.gsbvisite.R;
import com.example.gsbvisite.modele.*;

import java.util.ArrayList;

public class AccueilActivity extends AppCompatActivity {

    private Dal dal;
    ArrayList<Praticien> praticiens;
    ArrayList<Medicament> medicaments;
    ArrayList<RendezVous> rendezVous;
    Bundle bundlerdv = new Bundle();
    Bundle bundlepraticien = new Bundle();
    Bundle bundlemedicament = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        dal = Dal.getInstance(getBaseContext());
        MedicamentDAO medicamentDAO = new MedicamentDAO(getBaseContext());
        medicamentDAO.create();
        medicaments = medicamentDAO.read();
        PraticienDao praticienDao = new PraticienDao(getBaseContext());
        praticienDao.create();
        praticiens = praticienDao.read();
        RendezVousDao rendezVousDao = new RendezVousDao(getBaseContext());
        rendezVousDao.create();
        rendezVous = rendezVousDao.read();

        bundlemedicament.putParcelableArrayList("lesmedicaments", medicaments);
        bundlepraticien.putParcelableArrayList("lespraticiens", praticiens);
        bundlerdv.putParcelableArrayList("lesrendez-vous", rendezVous);
        gestionClick1();
    }


    private void gestionClick1() {
        ((Button) this.findViewById(R.id.btnmesrdv)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(AccueilActivity.this, "Clic sur Liste de rendez-vous", Toast.LENGTH_SHORT).show();
                Log.d("message", "Clic sur Liste de rendez-vous*******");
                Intent i = new Intent(AccueilActivity.this, RdvPraticienActivity.class);
                i.putExtras(bundlerdv);
                i.putExtras(bundlepraticien);
                startActivity(i);
            }
        });

        ((Button) this.findViewById(R.id.btnCreateRdv)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(AccueilActivity.this, "Clic sur créer rendez-vous", Toast.LENGTH_SHORT).show();
                Log.d("message", "Clic sur créer rendez-vous***");
                Intent i = new Intent(AccueilActivity.this, DemanderRdvActivity.class);
                i.putExtras(bundlerdv);
                i.putExtras(bundlepraticien);
                startActivity(i);
            }
        });

        ((Button) this.findViewById(R.id.btnlistmedic)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(AccueilActivity.this, "Clic sur Liste médicament", Toast.LENGTH_SHORT).show();
                Log.d("message", "Clic sur Liste médicament");
                Intent i = new Intent(AccueilActivity.this, ListeMedicamentsActivity.class);
                i.putExtras(bundlemedicament);
                startActivity(i);
            }
        });

    }
}
