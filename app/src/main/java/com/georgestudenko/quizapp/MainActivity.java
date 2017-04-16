package com.georgestudenko.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText euroEditText;
    EditText giocondaEditText;
    EditText f1EditText;
    RadioButton tulipsRadiobutton;
    RadioButton elephantRadiobutton;
    RadioButton ufoRadiobutton;
    CheckBox redCheckbox;
    CheckBox blueCheckbox;
    CheckBox yellowCheckbox;
    CheckBox orangeCheckbox;
    CheckBox whiteCheckbox;
    CheckBox greenCheckbox;
    double score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        euroEditText = (EditText) findViewById(R.id.euroAnswer);
        giocondaEditText = (EditText) findViewById(R.id.laGiocondaAnswer);
        f1EditText = (EditText) findViewById(R.id.formula1Answer);
        tulipsRadiobutton = (RadioButton) findViewById(R.id.tulips);
        elephantRadiobutton = (RadioButton) findViewById(R.id.fiftyInchesRadioButton);
        ufoRadiobutton = (RadioButton) findViewById(R.id.ufoAnswer);
        redCheckbox = (CheckBox) findViewById(R.id.red);
        blueCheckbox = (CheckBox) findViewById(R.id.blue);
        yellowCheckbox = (CheckBox) findViewById(R.id.yellow);
        whiteCheckbox = (CheckBox) findViewById(R.id.white);
        greenCheckbox = (CheckBox) findViewById(R.id.green);
        orangeCheckbox = (CheckBox) findViewById(R.id.orange);
        score = 0;
    }

    public void evaluateAnswers(View view) {
        // Evaluates Q1
        if(euroEditText.getText().toString().toLowerCase().contains("99") && euroEditText.getText().toString().toLowerCase().contains(getString(R.string.jan))){
            score++;
        }
        // Evaluates Q2
        if(tulipsRadiobutton.isChecked()){
            score++;
        }
        // Evaluates Q3
        if(whiteCheckbox.isChecked() || orangeCheckbox.isChecked() || greenCheckbox.isChecked()){
            //wrong answer
        } else if(redCheckbox.isChecked() && yellowCheckbox.isChecked() && blueCheckbox.isChecked()){
            score++;
        }
        // Evaluates Q4
        if(giocondaEditText.getText().toString().toLowerCase().contains("monalisa") || giocondaEditText.getText().toString().toLowerCase().contains("mona lisa")){
            score++;
        }
        // Evaluates Q5
        if(elephantRadiobutton.isChecked()){
            score++;
        }
        // Evaluates Q6
        if(f1EditText.getText().toString().toLowerCase().contains(getString(R.string.india))){
            score++;
        }
        // Evaluates Q7
        if(ufoRadiobutton.isChecked()){
            score++;
        }

        String message ="";

        switch ((int)score){
            case(0):
                message = getString(R.string.messageOne);
                break;
            case(1):
                message = getString(R.string.messageTwo);
                break;
            case(2):
                message = getString(R.string.messageThree);
                break;
            case(3):
                message = getString(R.string.messageFour);
                break;
            case(4):
                message = getString(R.string.messageFive);
                break;
            case(5):
                message = getString(R.string.messageSix);
                break;
            case(6):
                message = getString(R.string.messageSeven);
                break;
            case(7):
                message = getString(R.string.messageEight);
                break;
        }

        score = Math.round((score * 100) / 7);
        String youScored = getString(R.string.you_scored)+score +"% " + message ;
        Toast.makeText(this,youScored,Toast.LENGTH_LONG).show();
    public double calculateScoreInPercentage(){
        return Math.round((score * 100) / 7);
    }

        score=0;
    }
}
