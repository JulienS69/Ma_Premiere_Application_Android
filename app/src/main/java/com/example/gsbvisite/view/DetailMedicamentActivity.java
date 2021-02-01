package com.example.gsbvisite.view;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.gsbvisite.R;

public class DetailMedicamentActivity extends AppCompatActivity {

    private TextView txtCommercial;
    private TextView txtEffet;
    private TextView txtPrix;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_medicament);
        txtCommercial = (TextView) this.findViewById(R.id.txtCommercial);
        txtEffet = (TextView) this.findViewById(R.id.txtEffet);
        txtPrix = (TextView) this.findViewById(R.id.txtPrix);
        txtCommercial.setText(this.getIntent().getExtras().getString("nom"));
        txtEffet.setText(this.getIntent().getExtras().getString("effet"));
        Double prix = this.getIntent().getDoubleExtra("prix", 0);
        txtPrix.setText(prix.toString());
        gestionClic();
    }

    private void gestionClic() {
        ((Button) this.findViewById(R.id.btnRetourdeDetail)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(DetailMedicamentActivity.this, ListeMedicamentsActivity.class);
                startActivity(i);
            }
        });
    }
}