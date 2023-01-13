package com.example.gpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Dissapointing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dissapointing);
        Toast.makeText(getApplicationContext(),"We must accept finite disappointment but never lose infinite hope!!!",Toast.LENGTH_LONG).show();

        Button Return = findViewById(R.id.button6);
        Return.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), MainCalculation.class);
            startActivity(i);
        });

    }
}