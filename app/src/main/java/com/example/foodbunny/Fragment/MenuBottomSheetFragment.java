package com.example.foodbunny.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.foodbunny.R;
import com.example.foodbunny.adapter.CartAdapter;
import com.example.foodbunny.adapter.MenuAdapter;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.example.foodbunny.databinding.FragmentMenuBottomSheetBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.Arrays;

public class MenuBottomSheetFragment extends BottomSheetDialogFragment {

    // ViewBinding object for the bottom sheet layout
    private FragmentMenuBottomSheetBinding binding;

    // Called when the fragment is being created (before UI is created)
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(getContext(), "Bottom sheet opened", Toast.LENGTH_SHORT).show();
    }

    // Called to inflate the layout for this fragment
    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,
                              Bundle savedInstanceState) {
        // Inflate the layout using ViewBinding
        binding = FragmentMenuBottomSheetBinding.inflate(inflater, container, false);
        ArrayList<String> menuFoodName = new ArrayList<>(Arrays.asList("Burger", "Sandwich", "Momo", "Item", "Sandwich", "Momo","Burger", "Sandwich", "Momo", "Item", "Sandwich", "Momo"));

        // Create corresponding item prices
        ArrayList<String> menuItemPrice = new ArrayList<>(Arrays.asList("₹5", "₹6", "₹8", "₹9", "₹10", "₹10","₹5", "₹6", "₹8", "₹9", "₹10", "₹10"));

        // Create images for items (drawable resource IDs)
        ArrayList<Integer> menuImage = new ArrayList<>(Arrays.asList(
                R.drawable.menu2,
                R.drawable.menu2,
                R.drawable.menu2,
                R.drawable.menu2,
                R.drawable.menu2,
                R.drawable.menu2,
                R.drawable.menu2,
                R.drawable.menu2,
                R.drawable.menu2,
                R.drawable.menu2,
                R.drawable.menu2,
                R.drawable.menu2
        ));

        // Create adapter and pass the lists
        MenuAdapter adapter = new MenuAdapter(menuFoodName, menuItemPrice, menuImage);

        // Set LayoutManager for RecyclerView (for vertical list)
        binding.menuRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        // Set the adapter to RecyclerView
        binding.menuRecyclerView.setAdapter(adapter);
        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });



        return binding.getRoot(); // Return the root view of the binding
    }

    // Optional: Static factory methods or constants can be added here
    public static MenuBottomSheetFragment newInstance() {
        return new MenuBottomSheetFragment();
    }

    /*
     * Error in the original code:
     *
     * - The `MenuBottomSheetFragment` class was NOT declared as `public static`, and the fragment class needs
     *   to be either public or static to be properly recreated during state restoration (e.g., screen rotations).
     *
     * - If it were a static inner class, it would need to be declared as `public static` to avoid memory leaks
     *   or issues when the fragment is re-created from instance state.
     *
     * Fix:
     * - Change the class declaration to just `public class MenuBottomSheetFragment` because it is not a nested class.
     * - The `newInstance()` method can stay as `static` (a common practice for creating new instances of fragments).
     *
     * Final Code:
     * - The `static` modifier is not necessary on the fragment class itself, but it can be used in methods like `newInstance()`
     *   to create fragment instances.
     */
}
