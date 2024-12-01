package com.example.quizappwithminimalinterface;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroupQuestion1;
    CheckBox checkBoxQ2Option1, checkBoxQ2Option2, checkBoxQ2Option3, checkBoxQ2Option4;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Question 1 (Radio Buttons)
        radioGroupQuestion1 = findViewById(R.id.radioGroupQuestion1);

        // Question 2 (Check Boxes)
        checkBoxQ2Option1 = findViewById(R.id.checkBoxQ2Option1);
        checkBoxQ2Option2 = findViewById(R.id.checkBoxQ2Option2);
        checkBoxQ2Option3 = findViewById(R.id.checkBoxQ2Option3);
        checkBoxQ2Option4 = findViewById(R.id.checkBoxQ2Option4);

        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score = 0;

                // Check answer for Question 1
                int selectedRadioId = radioGroupQuestion1.getCheckedRadioButtonId();
                if (selectedRadioId == R.id.radioOption2) { // Assuming option 2 is correct
                    score++;
                }

                // Check answer for Question 2 (Checkboxes)
                if (checkBoxQ2Option1.isChecked() && checkBoxQ2Option3.isChecked() &&
                        !checkBoxQ2Option2.isChecked() && !checkBoxQ2Option4.isChecked()) { // Assuming option 1 & 3 are correct
                    score++;
                }

                // Display the score
                Toast.makeText(MainActivity.this, "Your Score: " + score + "/2", Toast.LENGTH_LONG).show();
            }
        });
    }
}