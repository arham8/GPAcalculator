package com.example.gpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class ResultScreen extends AppCompatActivity {

    private static final String TAG = "ResultScreen";
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);
        TextView SGPA =  findViewById(R.id.SGPA);
        Button Button = findViewById(R.id.button4);

        String getGPA = getIntent().getStringExtra("CGPA");
        SGPA.setText(getGPA);
        SGPA.setBackgroundColor(Color.parseColor("#FFD700"));
        SGPA.setTextColor(Color.parseColor("#000000"));

        Button.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), CGPAActivity.class);
            startActivity(i);
            i.putExtra("SGPA", getGPA);
            startActivity(i);
        });
        /*MobileAds.initialize(this);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);*/

        /*Double result = Double.parseDouble(getGPA);
        if(result >= 3.60 && result <= 4.00){
            Toast.makeText(getApplicationContext(),"First Class Division",Toast.LENGTH_SHORT).show();
            SGPA.setBackgroundColor(Color.parseColor("#FFD700"));
            SGPA.setTextColor(Color.parseColor("#000000"));
        }
        else if(result >= 3.00 && result <= 3.59){
            Toast.makeText(getApplicationContext(),"Second Class (Upper Division)",Toast.LENGTH_SHORT).show();
            SGPA.setBackgroundColor(Color.parseColor("#FFA500"));
        }

        else if(result >= 2.00 && result <= 2.99){
            Toast.makeText(getApplicationContext(),"Second Class (Upper Division)",Toast.LENGTH_SHORT).show();
            SGPA.setBackgroundColor(Color.parseColor(" #996633"));
            SGPA.setTextColor(Color.parseColor("#FFFFFF"));
        }*/

       /* Button.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                ImageView img = (ImageView)findViewById(R.id.imageView3);
                img.setBackgroundResource(R.drawable.happylad);

                AnimationDrawable myFrameAnimation = (AnimationDrawable) img.getBackground();
                myFrameAnimation.start();
            }
        });*/
    }

}