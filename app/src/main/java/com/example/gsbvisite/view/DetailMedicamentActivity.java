package com.example.gsbvisite.view;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.gsbvisite.R;
import com.example.gsbvisite.modele.Medicament;

public class DetailMedicamentActivity extends AppCompatActivity {

    private TextView txtCommercial;
    private TextView txtEffet;
    private TextView txtPrix;
    private TextView txtComposition;
    private TextView txtContreIndic;
    private TextView txtDepotLegal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_medicament);
        txtCommercial = (TextView) this.findViewById(R.id.txtCommercial);
        txtEffet = (TextView) this.findViewById(R.id.txtEffet);
        txtPrix = (TextView) this.findViewById(R.id.txtPrix);
        txtComposition = (TextView) this.findViewById(R.id.txtComposition);
        txtContreIndic = (TextView) this.findViewById(R.id.txtContreIndic);
        txtDepotLegal = (TextView) this.findViewById(R.id.txtDepotLegal);
        Medicament medicament = getIntent().getParcelableExtra("medicament");
       // txtCommercial.setText(this.getIntent().getExtras().getString("nom"));
       // txtEffet.setText(this.getIntent().getExtras().getString("effet"));
        //Double prix = this.getIntent().getDoubleExtra("prix", 0);
        //txtPrix.setText(prix.toString());
        txtCommercial.setText((medicament.getMNomCommercial()));
        txtEffet.setText(medicament.getEffet());
        Double prix = medicament.getMPrixEchant();
        txtPrix.setText(prix.toString());
        txtComposition.setText(medicament.getMComposition());
        txtContreIndic.setText(medicament.getContreindic());
        txtDepotLegal.setText(medicament.getMDepotLegal());
        gestionClic();
    }

    private void gestionClic() {
        ((Button) this.findViewById(R.id.btnRetourdeDetail)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}