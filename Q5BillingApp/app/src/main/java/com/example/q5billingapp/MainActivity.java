package com.example.q5billingapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioGroup breadSizeGroup;
    CheckBox paneerCheckBox, mushroomCheckBox, onionCheckBox, jalapenoCheckBox;
    AutoCompleteTextView drinkAutoComplete;
    Button orderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        breadSizeGroup = findViewById(R.id.breadSizeGroup);
        paneerCheckBox = findViewById(R.id.paneerCheckBox);
        mushroomCheckBox = findViewById(R.id.mushroomCheckBox);
        onionCheckBox = findViewById(R.id.onionCheckBox);
        jalapenoCheckBox = findViewById(R.id.jalapenoCheckBox);
        drinkAutoComplete = findViewById(R.id.drinkAutoComplete);
        orderButton = findViewById(R.id.orderButton);

        // Setup auto-complete for drinks
        String[] drinks = {"Coke", "Pepsi", "Fanta"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, drinks);
        drinkAutoComplete.setAdapter(adapter);

        // Order button click event
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int totalAmount = 0;
                StringBuilder orderDetails = new StringBuilder("Order Details:\n");

                // Calculate bread size cost
                int selectedBreadId = breadSizeGroup.getCheckedRadioButtonId();
                if (selectedBreadId == R.id.radio15cm) {
                    totalAmount += 100;
                    orderDetails.append("Bread: 15cm\n");
                } else if (selectedBreadId == R.id.radio30cm) {
                    totalAmount += 200;
                    orderDetails.append("Bread: 30cm\n");
                }

                // Calculate toppings cost
                if (paneerCheckBox.isChecked()) {
                    totalAmount += 50;
                    orderDetails.append("Topping: Paneer\n");
                }
                if (mushroomCheckBox.isChecked()) {
                    totalAmount += 50;
                    orderDetails.append("Topping: Mushroom\n");
                }
                if (onionCheckBox.isChecked()) {
                    totalAmount += 30;
                    orderDetails.append("Topping: Onion\n");
                }
                if (jalapenoCheckBox.isChecked()) {
                    totalAmount += 30;
                    orderDetails.append("Topping: Jalapeno\n");
                }

                // Calculate drink cost
                String selectedDrink = drinkAutoComplete.getText().toString();
                if (!selectedDrink.isEmpty()) {
                    totalAmount += 40;
                    orderDetails.append("Drink: ").append(selectedDrink).append("\n");
                }

                // Display order details and total amount
                orderDetails.append("Total Amount: ₹").append(totalAmount);

                // Show alert dialog with order summary
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Order Summary")
                        .setMessage(orderDetails.toString())
                        .setPositiveButton("OK", null)
                        .show();
            }
        });
    }
}