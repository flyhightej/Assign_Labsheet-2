package com.example.q2passingdatawithexplicitintent;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {
    TextView displayInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        displayInfo = findViewById(R.id.displayInfo);

        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        String phone = getIntent().getStringExtra("phone");

        displayInfo.setText("Name: " + name + "\nEmail: " + email + "\nPhone: " + phone);
    }
}
