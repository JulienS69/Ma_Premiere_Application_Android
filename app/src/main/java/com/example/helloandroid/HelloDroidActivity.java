package com.example.helloandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class HelloDroidActivity extends AppCompatActivity {
    private TextView message;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message = findViewById(R.id.clickCounter);
        ImageView droid = findViewById(R.id.chassagnesImage);

        //Define and attach click listener
        droid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tapDroid();
            }
        });
    }

    private void tapDroid() {
        counter++;
        String countAsText;
        /*
         * In real applications you should not write switch like the one below.
         * Use resource of type "Quantity strings (plurals)" instead.
         * See https://developer.android.com/guide/topics/resources/string-resource#Plurals
         */
        switch (counter) {
            case 1:
                countAsText = "pour la première fois";
                break;
            case 2:
                countAsText = "pour la seconde fois";
                break;
            default:
                countAsText = String.format("%d fois", counter);
        }
        message.setText(String.format("Tu touche le logo %s", countAsText));
    }
}