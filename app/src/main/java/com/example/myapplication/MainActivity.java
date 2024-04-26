package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText input,  output;
    Spinner convert_from_spinner, convert_to_spinner;
    TextView live_rate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

         input = findViewById(R.id.input);
         output = findViewById(R.id.output);
         live_rate = findViewById(R.id.subtitle2);
        Button result = findViewById(R.id.convert);

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertCurrency();
            }
        });
        // Initialize spinners
        convert_from_spinner= findViewById(R.id.convert_from);
        convert_to_spinner = findViewById(R.id.convert_to);

        // Create lists of values for the spinners
        List<String> spinner1Values = new ArrayList<>();
        spinner1Values.add("USD");
        spinner1Values.add("EUR");
        spinner1Values.add("GBP");
        spinner1Values.add("IQD");
        spinner1Values.add("IRR");

        List<String> spinner2Values = new ArrayList<>();
        spinner2Values.add("USD");
        spinner2Values.add("EUR");
        spinner2Values.add("GBP");
        spinner2Values.add("IQD");
        spinner2Values.add("IRR");

        // Create ArrayAdapter for spinners and set the values
        ArrayAdapter<String> spinner1Adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinner1Values);
        spinner1Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        convert_from_spinner.setAdapter(spinner1Adapter);

        ArrayAdapter<String> spinner2Adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinner2Values);
        spinner2Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        convert_to_spinner.setAdapter(spinner2Adapter);
    }

    public void convertCurrency() {
        // Get input value
        String inputValueString = input.getText().toString().trim();
        if (inputValueString.isEmpty()) {
            Toast.makeText(this, "Please enter a valid input value", Toast.LENGTH_SHORT).show();
            return;
        }
        double inputValue = Double.parseDouble(inputValueString);

        // Get selected currency codes
        String fromCurrency = convert_from_spinner.getSelectedItem().toString();
        String toCurrency = convert_to_spinner.getSelectedItem().toString();

        // CALCULATION
        double outputValue;
//        FOR USD
        if (fromCurrency.equals("USD") && toCurrency.equals("EUR")) {
            outputValue = inputValue * 0.93473502;
        }
        else if (fromCurrency.equals("USD") && toCurrency.equals("GBP")) {
            outputValue = inputValue * 0.8028212;
        }

        else if (fromCurrency.equals("USD") && toCurrency.equals("IQD")) {
            outputValue = inputValue * 1309.83581261;
        }
        else if (fromCurrency.equals("USD") && toCurrency.equals("IRR")) {
            outputValue = inputValue * 41862.54833839;
        }
//        for EUR
        else if (fromCurrency.equals("EUR") && toCurrency.equals("USD")) {
            outputValue = inputValue * 1.07254977;
        }
        else if (fromCurrency.equals("EUR") && toCurrency.equals("GBP")) {
            outputValue = inputValue * 0.85788717;
        }
        else if (fromCurrency.equals("EUR") && toCurrency.equals("IQD")) {
            outputValue = inputValue * 1404.79066149;
        }
        else if (fromCurrency.equals("EUR") && toCurrency.equals("IRR")) {
            outputValue = inputValue * 44884.13054614;
        }
// for GBP
        else if (fromCurrency.equals("GBP") && toCurrency.equals("USD")) {
            outputValue = inputValue * 1.25022241;
        }
        else if (fromCurrency.equals("GBP") && toCurrency.equals("EUR")) {
            outputValue = inputValue * 1.16565445;
        }
        else if (fromCurrency.equals("GBP") && toCurrency.equals("IQD")) {
            outputValue = inputValue * 1637.50049036;
        }
        else if (fromCurrency.equals("GBP") && toCurrency.equals("IRR")) {
            outputValue = inputValue * 52319.38664819;
        }

// for IQD
        else if (fromCurrency.equals("IQD") && toCurrency.equals("USD")) {
            outputValue = inputValue * 0.00076349437;
        }
        else if (fromCurrency.equals("IQD") && toCurrency.equals("EUR")) {
            outputValue = inputValue * 0.00071184983;
        }
        else if (fromCurrency.equals("IQD") && toCurrency.equals("GBP")) {
            outputValue = inputValue * 0.00061068684;
        }
      else if (fromCurrency.equals("IQD") && toCurrency.equals("IRR")) {
                outputValue = inputValue * 31.9507609;
            }


      // FOR IRR
      else if (fromCurrency.equals("IRR") && toCurrency.equals("USD")) {
                outputValue = inputValue * 0.000023895968;
      }
      else if (fromCurrency.equals("IRR") && toCurrency.equals("EUR")) {
                outputValue = inputValue * 0.000022279589;
      }
      else if (fromCurrency.equals("IRR") && toCurrency.equals("GBP")) {
                outputValue = inputValue * 0.000019113374;
      }
      else if (fromCurrency.equals("IRR") && toCurrency.equals("IQD")) {
                outputValue = inputValue * 0.031298159;
      }
        else {
            // No conversion available, set output value same as input value
            outputValue = inputValue;
        }

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String formattedOutput = decimalFormat.format(outputValue);

        // Display converted value
        output.setText(String.valueOf(formattedOutput));
    }
}