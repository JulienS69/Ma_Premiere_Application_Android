package com.example.android_ppe;

import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Medicament extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicament);
        //1 - Configuration Toolbar
        this.configureToolbar();
        //2 - Configuration Navigation View
        this.configureNavigation();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //2 Ajouter le menu à la Toolbar
        getMenuInflater().inflate(R.menu.menu_activity, menu);
        return true;
    }


    private void configureToolbar() {
        // Get the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Médicaments");
        // Sets the Toolbar
        setSupportActionBar(toolbar);
    }
    private void configureNavigation() {
        BottomNavigationView bottomNavigationView;
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        // bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                (item) -> {
                    Intent intent;
                    switch (item.getItemId()) {
                        //"action_medecine" définis dans le fichier situé dans le dossier menu
                        case R.id.action_accueil: {
                            intent = new Intent(Medicament.this, RendezVous.class);
                            startActivity(intent);
                            overridePendingTransition(0,0);
                            break;
                        }
                        case R.id.action_settings: {
                            intent = new Intent(Medicament.this, Profil.class);
                            startActivity(intent);
                            overridePendingTransition(0,0);
                            break;
                        }
                    }
                    return true;
                }
        );
    }
}