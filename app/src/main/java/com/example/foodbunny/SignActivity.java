package com.example.foodbunny;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.foodbunny.databinding.ActivityLoginBinding;
import com.example.foodbunny.databinding.ActivitySignBinding;

public class SignActivity extends AppCompatActivity {
    private ActivitySignBinding binding; // Correct way to declare binding in Java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign);
        // Initialize View Binding
        binding = ActivitySignBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // Set onClickListener for the button
        binding.alreadyhavebutton.setOnClickListener(view -> {
            Intent intent = new Intent(SignActivity.this, LoginActivity.class);
            startActivity(intent);
        });

    }
}