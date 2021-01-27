package com.example.gsbvisite.view;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.gsbvisite.R;

public class DemanderRdvActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demander_rdv);
        gestionClick();
    }

    private void gestionClick() {
        ((ImageButton) this.findViewById(R.id.btnRetourPriseRdv)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(DemanderRdvActivity.this, "Retour à l'accueil", Toast.LENGTH_SHORT).show();
                Log.d("message", "Retour à l'accueil");
                Intent i = new Intent(DemanderRdvActivity.this, AccueilActivity.class);
                startActivity(i);
            }
        });

    }
}