package com.example.android_ppe;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

public class PrendreRDV extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prendre_r_d_v);

        //1- Configuration ToolBar
        this.configureToolbar();
    }


    private void configureToolbar() {
        //Get the toolbar (Serialise)
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //Set the toolbar
        toolbar.setTitle("Prendre un Rendez-Vous");
        setSupportActionBar(toolbar);
        //Get a support ActionBar corresponding to this toolbar
        // Ce code permet d'activer le button "up" dans la "Toolbar"
        ActionBar actionBar = getSupportActionBar();
        //Enable the Up button
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}