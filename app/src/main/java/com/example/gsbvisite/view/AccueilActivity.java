package com.example.gsbvisite.view;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.gsbvisite.R;

public class AccueilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        gestionClick1();
    }


    private void gestionClick1() {
        ((Button) this.findViewById(R.id.btnmesrdv)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(AccueilActivity.this, "Clic sur Liste de rendez-vous", Toast.LENGTH_SHORT).show();
                Log.d("message", "Clic sur Liste de rendez-vous*******");
            }
        });

        ((Button) this.findViewById(R.id.btnCreateRdv)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(AccueilActivity.this, "Clic sur créer rendez-vous", Toast.LENGTH_SHORT).show();
                Log.d("message", "Clic sur créer rendez-vous***");
            }
        });

        ((Button) this.findViewById(R.id.btnlistmedic)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(AccueilActivity.this, "Clic sur Liste médicament", Toast.LENGTH_SHORT).show();
                Log.d("message", "Clic sur Liste médicament");
                Intent i = new Intent(AccueilActivity.this, ListeMedicaments.class);
                startActivity(i);
            }
        });

    }
}
