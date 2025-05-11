package com.example.foodbunny;

import android.os.Bundle;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.example.foodbunny.Fragment.MenuBottomSheetFragment;
import com.example.foodbunny.databinding.ActivityMainBinding;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // Initialize BottomNavigationView
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);


        // Find the NavController (Must be linked with a FragmentContainerView in XML)
        NavController navController = Navigation.findNavController(this, R.id.fragmentContainerView);

        // Connect BottomNavigationView with NavController
        NavigationUI.setupWithNavController(bottomNav, navController);
    }
}