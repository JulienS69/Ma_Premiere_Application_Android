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

public class ListeMedicamentsActivity extends AppCompatActivity {

    ListView lvMedicaments;
    ArrayList<Medicament> medicaments;
    MedicamentController medicamentController;
    private MedicamentController controle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listemedicaments);
        lvMedicaments =(ListView)findViewById(R.id.listMedic);
        String[] listStrings ={"Aspirine", "Doliprane", "Ibuprofène"};
        lvMedicaments.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listStrings));

        this.medicamentController = MedicamentController.getInstance(getBaseContext());
        medicaments = medicamentController.medicaments();
        this.controle = MedicamentController.getInstance(this);
        gestionClick();
        creerList();
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

        lvMedicaments.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //TODO Auto-generated method stub
                String value=(String)lvMedicaments.getAdapter().getItem(position);
                Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
            }
        });

    }
        private void creerList(){
            ArrayList<Medicament> lesmedicaments = controle.medicaments();
            if (lesmedicaments != null){
                ListView listView = (ListView)findViewById(R.id.listMedic);
                MedicamentListAdapter adapter = new MedicamentListAdapter(this, lesmedicaments);
                listView.setAdapter(adapter);
            }

        }

}