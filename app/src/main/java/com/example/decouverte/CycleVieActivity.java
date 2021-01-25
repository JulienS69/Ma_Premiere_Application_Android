package com.example.decouverte;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class CycleVieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cycledevie);
        Log.i("decouverte", "On est dans le Create");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("decouverte", "On est dans le Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("decouverte", "On est dans le Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("decouverte", "On est dans le Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("decouverte", "On est dans le Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("decouverte", "On est dans le Destroy");
    }
}