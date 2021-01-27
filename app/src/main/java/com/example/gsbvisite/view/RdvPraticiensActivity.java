package com.example.gsbvisite.view;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.gsbvisite.R;

public class RdvPraticiensActivity extends AppCompatActivity {

    ListView lvRdvPraticiens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rdv_praticiens);
        lvRdvPraticiens = (ListView)findViewById(R.id.listRdvPraticiens);
        String[] listStrings ={"2021-03-05", "2021-03-08", "2021-09-03", "2021-09-20", "2021-10-04"};
        lvRdvPraticiens.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listStrings));
        gestionClick2();
    }

    private void gestionClick2() {
        ((ImageButton) this.findViewById(R.id.btnRetourdeRdvPraticiens)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(RdvPraticiensActivity.this, "Retour à l'accueil", Toast.LENGTH_SHORT).show();
                Log.d("message", "Retour à l'accueil");
                Intent i = new Intent(RdvPraticiensActivity.this, AccueilActivity.class);
                startActivity(i);
            }
        });

        lvRdvPraticiens.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //TODO Auto-generated method stub
                String value=(String)lvRdvPraticiens.getAdapter().getItem(position);
                Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
            }
        });
    }
}