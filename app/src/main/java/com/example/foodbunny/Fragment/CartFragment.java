package com.example.foodbunny.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;


import com.example.foodbunny.R;
import com.example.foodbunny.adapter.CartAdapter;
import com.example.foodbunny.databinding.FragmentCartBinding;
import java.util.ArrayList;
import java.util.Arrays;

public class CartFragment extends Fragment {

    private FragmentCartBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout using ViewBinding
        binding = FragmentCartBinding.inflate(inflater, container, false);

        // Create sample food names
        ArrayList<String> cartFoodName = new ArrayList<>(Arrays.asList("Burger", "Sandwich", "Momo", "Item", "Sandwich", "Momo"));

        // Create corresponding item prices
        ArrayList<String> cartItemPrice = new ArrayList<>(Arrays.asList("$5", "$6", "$8", "$9", "$10", "$10"));

        // Create images for items (drawable resource IDs)
        ArrayList<Integer> cartImage = new ArrayList<>(Arrays.asList(
                R.drawable.menu2,
                R.drawable.menu2,
                R.drawable.menu2,
                R.drawable.menu2,
                R.drawable.menu2,
                R.drawable.menu2
        ));

        // Create adapter and pass the lists
        CartAdapter adapter = new CartAdapter(cartFoodName, cartItemPrice, cartImage);

        // Set LayoutManager for RecyclerView (for vertical list)
        binding.cartrecyclerview.setLayoutManager(new LinearLayoutManager(requireContext()));

        // Set the adapter to RecyclerView
        binding.cartrecyclerview.setAdapter(adapter);

        // Return the root view
        return binding.getRoot();
    }
}
