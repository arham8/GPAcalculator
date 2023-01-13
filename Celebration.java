package com.example.gpacalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Celebration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celebration);
        Toast.makeText(getApplicationContext(),"You, my friend are a WINNER!!!",Toast.LENGTH_LONG).show();

        Button Return = findViewById(R.id.button6);
        Return.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), MainCalculation.class);
            startActivity(i);
        });
    }
    /*public void onBackPressed() {
        AlertDialog.Builder box = new AlertDialog.Builder(this);
        box.setTitle("Confirm Exit");
        box.setMessage("Are you sure you want to exit?");
        box.setCancelable(false);
        box.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        box.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert = box.create();
        alert.show();

    }*/

}
