package com.example.gpacalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;

public class MainCalculation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_calculation);
        Button CalculateSGPA = findViewById(R.id.CalculateSGPA);
        Button Reset = findViewById(R.id.Reset);

        Reset.setOnClickListener(v -> {
            if (v==Reset) {
                startActivity(new Intent(this, MainCalculation.class));
            }
        });


        CalculateSGPA.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), ResultScreen.class);
            startActivity(i);
            String gpa = getGPA();
            i.putExtra("CGPA", gpa);
            startActivity(i);
        });
    }

    public String getGPA() {
        ArrayList<Double> myGradeList = new ArrayList<>();
        ArrayList<Integer> myCourseList = new ArrayList<>();

        String hours1, hours2, hours3, hours4, hours5, hours6, hours7, hours8, hours9, hours10, hours11;
        String grade1, grade2, grade3, grade4, grade5, grade6, grade7, grade8, grade9, grade10, grade11;

        try {
            grade1 = ((EditText) findViewById(R.id.G1)).getText().toString();
            grade2 = ((EditText) findViewById(R.id.G2)).getText().toString();
            grade3 = ((EditText) findViewById(R.id.G3)).getText().toString();
            grade4 = ((EditText) findViewById(R.id.G4)).getText().toString();
            grade5 = ((EditText) findViewById(R.id.G5)).getText().toString();
            grade6 = ((EditText) findViewById(R.id.G6)).getText().toString();
            grade7 = ((EditText) findViewById(R.id.G7)).getText().toString();
            grade8 = ((EditText) findViewById(R.id.G8)).getText().toString();
            grade9 = ((EditText) findViewById(R.id.G9)).getText().toString();
            grade10 = ((EditText) findViewById(R.id.G10)).getText().toString();
            grade11 = ((EditText) findViewById(R.id.G11)).getText().toString();

            hours1 = ((EditText) findViewById(R.id.CH1)).getText().toString();
            hours2 = ((EditText) findViewById(R.id.CH2)).getText().toString();
            hours3 = ((EditText) findViewById(R.id.CH3)).getText().toString();
            hours4 = ((EditText) findViewById(R.id.CH4)).getText().toString();
            hours5 = ((EditText) findViewById(R.id.CH5)).getText().toString();
            hours6 = ((EditText) findViewById(R.id.CH6)).getText().toString();
            hours7 = ((EditText) findViewById(R.id.CH7)).getText().toString();
            hours8 = ((EditText) findViewById(R.id.CH8)).getText().toString();
            hours9 = ((EditText) findViewById(R.id.CH9)).getText().toString();
            hours10 = ((EditText) findViewById(R.id.CH10)).getText().toString();
            hours11 = ((EditText) findViewById(R.id.CH11)).getText().toString();


        } catch (Exception e) {
            alertBox("Invalid/Missing data", "Please enter credit hours and/or grade properly");
            return "";
        }

        checker(grade1, hours1, myGradeList, myCourseList);
        checker(grade2, hours2, myGradeList, myCourseList);
        checker(grade3, hours3, myGradeList, myCourseList);
        checker(grade4, hours4, myGradeList, myCourseList);
        checker(grade5, hours5, myGradeList, myCourseList);
        checker(grade6, hours6, myGradeList, myCourseList);
        checker(grade7, hours7, myGradeList, myCourseList);
        checker(grade8, hours8, myGradeList, myCourseList);
        checker(grade9, hours9, myGradeList, myCourseList);
        checker(grade10,hours10,myGradeList, myCourseList);
        checker(grade11,hours11,myGradeList, myCourseList);

        double sum = 0;
        double numerator = 0; 

        for (int i = 0; i < myGradeList.size() ; i++) {
            numerator += (myGradeList.get(i) * myCourseList.get(i));
            sum += (myCourseList.get(i));
        }

        double newGPA = (numerator / sum );
        return String.format("%.2f", newGPA);
    }

    public void checker(String letter, String credits, ArrayList<Double> myGradeList, ArrayList<Integer> myCourseList) {
        String checkGrade = letter.trim();
        String checkHours = credits.trim();
        if (checkGrade.length() == 0) {
            if (checkHours.length() != 0) {
                alertBox("Error", "Please fill all the boxes in the row to proceed");
            }
            return;
        }
        if (checkHours.length() == 0) {
            alertBox("Error", "Please fill all the boxes in the row to proceed");
            return;
        }
        double result = -1;
        switch (letter) {
            case "A+":
            case "A":
                result = 4;
                break;
            case "A-":
                result = 3.7;
                break;
            case "B+":
                result = 3.3;
                break;
            case "B":
                result = 3.0;
                break;
            case "B-":
                result = 2.7;
                break;
            case "C+":
                result = 2.3;
                break;
            case "C":
                result = 2;
                break;
            case "C-":
                result = 1.7;
                break;
            case "D+":
                result = 1.3;
                break;
            case "D":
                result = 1;
                break;
            case "D-":
                result = 0.7;
                break;
            case "F":
                result = 0;
                break;
        }
        if (result == -1) {
            alertBox("Invalid Letter Grade", "Please enter a valid grade between A+ and F");
            return;
        }
        myGradeList.add(result);
        myCourseList.add(Integer.parseInt(checkHours));
    }

    public void alertBox(String title, String message) {
        AlertDialog.Builder box = new AlertDialog.Builder(MainCalculation.this);
        box.setTitle(title);
        box.setMessage(message);
        box.setPositiveButton("OK", (dialogInterface, i) -> dialogInterface.cancel());
        AlertDialog alert = box.create();
        alert.show();
    }


}