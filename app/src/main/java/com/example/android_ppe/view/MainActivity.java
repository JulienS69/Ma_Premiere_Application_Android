package com.example.android_ppe.view;

import android.content.Intent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android_ppe.R;

/**
 * Classe MainActivity.
 * @author : Julien. SEUX.
 * created on  26/01/2021.
 * modified on 10/02/2021.
 * Classe principale, permettant la demande à l'utilisateur du mot de passe.
 */

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
                            Intent intent = new Intent(MainActivity.this, RendezVousActivity.class);
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
