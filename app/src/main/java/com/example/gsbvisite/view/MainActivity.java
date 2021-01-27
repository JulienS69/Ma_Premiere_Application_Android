package com.example.gsbvisite.view;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.gsbvisite.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gestionClic();
    }

    private void gestionClic() {
        ((ImageButton) this.findViewById(R.id.btnlogo)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Bienvenue dans l'accueil", Toast.LENGTH_SHORT).show();
                Log.d("message", "Bienvenue dans l'accueil");
                Intent intent = new Intent(MainActivity.this, AccueilActivity.class);
                startActivity(intent);
            }
        });
    }
}