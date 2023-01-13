package com.example.gpacalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import static android.content.ContentValues.TAG;

public class CGPAActivity extends AppCompatActivity {

    private static final String TAG = "CGPAActivity";
    private InterstitialAd mInterstitialAd;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgpaactivity);
        Button Button = findViewById(R.id.button5);
        TextView SGPA2 =  findViewById(R.id.SGPA2);
        Button ReCalculate = findViewById(R.id.Recalculate);
        Button Happy = findViewById(R.id.Happy);
        Button Sad = findViewById(R.id.Sad);

        AdRequest madRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this, "ca-app-pub-3940256099942544/1033173712", madRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                // The mInterstitialAd reference will be null until an ad is loaded.
                mInterstitialAd = interstitialAd;
                Log.i(TAG, "onAdLoaded");
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                // Handle the error
                Log.i(TAG, loadAdError.getMessage());
                mInterstitialAd = null;
            }
        });

        Button.setOnClickListener(v -> {
            String getGPA = getCGPA();
            SGPA2.setText(getGPA);
            SGPA2.setBackgroundColor(Color.parseColor("#FFD700"));
            SGPA2.setTextColor(Color.parseColor("#000000"));
        });
        ReCalculate.setOnClickListener(v -> {
            if (v==ReCalculate) {
                startActivity(new Intent(this, MainCalculation.class));
            }
        });
        Happy.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), Celebration.class);
            if (mInterstitialAd != null) {
                mInterstitialAd.show(CGPAActivity.this);
            } else {
                Log.d("TAG", "The interstitial ad wasn't ready yet.");
            }
            startActivity(i);
        });
        Sad.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), Dissapointing.class);
            startActivity(i);
            if (mInterstitialAd != null) {
                mInterstitialAd.show(CGPAActivity.this);
            } else {
                Log.d("TAG", "The interstitial ad wasn't ready yet.");
            }
        });

    }


    public String getCGPA() {
        String sem1, sem2, sem3, sem4, sem5, sem6, sem7;
        double totalGPA = 0;
        int count = 0;
        sem1 = ((EditText) findViewById(R.id.editTextTextPersonName7)).getText().toString();
        sem2 = ((EditText) findViewById(R.id.editTextTextPersonName2)).getText().toString();
        sem3 = ((EditText) findViewById(R.id.editTextTextPersonName3)).getText().toString();
        sem4 = ((EditText) findViewById(R.id.editTextTextPersonName4)).getText().toString();
        sem5 = ((EditText) findViewById(R.id.editTextTextPersonName5)).getText().toString();
        sem6 = ((EditText) findViewById(R.id.editTextTextPersonName6)).getText().toString();
        sem7 = ((EditText) findViewById(R.id.editTextTextPersonName)).getText().toString();

        if (!(sem1.isEmpty())) {
            totalGPA += Double.parseDouble(sem1);
            count ++;
        }

        if (!(sem2.isEmpty())) {
            totalGPA += Double.parseDouble(sem2);
            count ++;
        }

        if (!(sem3.isEmpty())) {
            totalGPA += Double.parseDouble(sem3);
            count ++;
        }

        if (!(sem4.isEmpty())) {
            totalGPA += Double.parseDouble(sem4);
            count ++;
        }
        if (!(sem5.isEmpty())) {
            totalGPA += Double.parseDouble(sem5);
            count ++;
        }

        if (!(sem6.isEmpty())) {
            totalGPA += Double.parseDouble(sem6);
            count ++;
        }

        if (!(sem7.isEmpty())) {
            totalGPA += Double.parseDouble(sem7);
            count ++;
        }

        String getGPA = getIntent().getStringExtra("SGPA");
        double getAns = Double.parseDouble(getGPA);
        double getVal = (totalGPA + getAns) / (count + 1);
        String finAns = String.format("%.2f", getVal);
        return finAns;

    }


}