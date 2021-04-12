package com.example.android_ppe;

import android.content.Intent;
import android.view.Menu;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.idApplication);
        editText.setOnEditorActionListener((v, actionId, event) -> {
                    // Si l'utilisateur a cliqué sur Valider
                    if (actionId == EditorInfo.IME_ACTION_DONE) {
                        String value = editText.getText().toString();
                        String marqueur = "9999";
                        // Si le code saisi est valide
                        if (value.compareTo(marqueur) == 0) {
                            Intent intent = new Intent(MainActivity.this, RendezVous.class);
                            startActivity(intent);
                            //Si code non valide
                        } else
                            Toast.makeText(MainActivity.this, "Code erroné", Toast.LENGTH_SHORT).show();
                    }
                    return false;
                }

        );

    }

}
