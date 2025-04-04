package com.example.foodbunny;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.foodbunny.databinding.ActivityChooseLocationBinding;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.foodbunny.databinding.ActivityChooseLocationBinding;
import com.example.foodbunny.databinding.ActivitySignBinding;

public class ChooseLocationActivity extends AppCompatActivity {
    private ActivityChooseLocationBinding binding; // Correct way to declare binding in Java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_choose_location);
        // Inflate the layout using View Binding (instead of findViewById)
        binding = ActivityChooseLocationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Step 1: Define the list of locations
        String[] locationList = {"Delhi", "Jaipur", "Agra", "Mathura", "Gaziabad"};
        // Step 2: Create an ArrayAdapter to convert the list into a dropdown format
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,  // Context (current activity)
                android.R.layout.simple_list_item_1,  // Predefined layout for list items
                locationList  // Data source (array of locations)
        );

        // Step 3: Get reference to the AutoCompleteTextView from the binding
        AutoCompleteTextView autoCompleteTextView = binding.listOfLocations;

        // Step 4: Set the adapter to the AutoCompleteTextView
        autoCompleteTextView.setAdapter(adapter);

    }
}