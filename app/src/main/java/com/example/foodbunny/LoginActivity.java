package com.example.foodbunny;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.foodbunny.databinding.ActivityLoginBinding;
import com.example.foodbunny.databinding.ActivityStartBinding;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding; // Correct way to declare binding in Java

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);



    }
}