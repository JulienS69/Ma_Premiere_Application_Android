package com.example.android_ppe.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import com.example.android_ppe.R;

import com.google.android.material.bottomnavigation.BottomNavigationView;


/**
 * Classe Profil.
 * @author : Julien. SEUX.
 * created on  26/01/2021.
 * modified on 10/05/2021.
 * Classe permettant au visiteur de pouvoir changer de mot de passe.
 */
public class Profil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
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
        toolbar.setTitle("Paramètres");
        // Sets the Toolbar
        setSupportActionBar(toolbar);
    }


    private void configureNavigation() {
        BottomNavigationView bottomNavigationView;
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        //bottomNavigationView.setOnNavigationItemSelectedListener();
        bottomNavigationView.setSelectedItemId(R.id.action_settings);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                (item) -> {
                    Intent intent;
                    switch (item.getItemId()) {
                        //"action_medecine" définis dans le fichier situé dans le dossier menu
                        case R.id.action_accueil: {
                            intent = new Intent(Profil.this, RendezVousActivity.class);
                            startActivity(intent);
                            overridePendingTransition(0,0);
                            break;
                        }
                        case R.id.action_settings: {
                            intent = new Intent(Profil.this, Profil.class);
                            startActivity(intent);
                            overridePendingTransition(0,0);
                            break;
                        }
                        case R.id.action_medecine: {
                            intent = new Intent(Profil.this, MedicamentActivity.class);
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