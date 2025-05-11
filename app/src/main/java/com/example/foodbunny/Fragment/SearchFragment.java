package com.example.foodbunny.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.foodbunny.R;
import com.example.foodbunny.adapter.MenuAdapter;
import com.example.foodbunny.databinding.FragmentSearchBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchFragment extends Fragment {

    private FragmentSearchBinding binding;

    // Original full menu data
    private final ArrayList<String> originalMenuFoodName = new ArrayList<>(Arrays.asList(
            "Burger", "Sandwich", "Momo", "Item", "Sandwich", "Momo",
            "Burger", "Sandwich", "Momo", "Item", "Sandwich", "Momo"
    ));

    private final ArrayList<String> originalMenuItemPrice = new ArrayList<>(Arrays.asList(
            "₹5", "₹6", "₹8", "₹9", "₹10", "₹10",
            "₹5", "₹6", "₹8", "₹9", "₹10", "₹10"
    ));

    private final ArrayList<Integer> originalMenuImage = new ArrayList<>(Arrays.asList(
            R.drawable.menu2, R.drawable.menu2, R.drawable.menu2,
            R.drawable.menu2, R.drawable.menu2, R.drawable.menu2,
            R.drawable.menu2, R.drawable.menu2, R.drawable.menu2,
            R.drawable.menu2, R.drawable.menu2, R.drawable.menu2
    ));

    // Filtered list for search results
    private final ArrayList<String> filteredMenuFoodName = new ArrayList<>();
    private final ArrayList<String> filteredMenuItemPrice = new ArrayList<>();
    private final ArrayList<Integer> filteredMenuImage = new ArrayList<>();

    private MenuAdapter adapter;

    public SearchFragment() {
        // Required empty public constructor
    }

    public static SearchFragment newInstance(String param1, String param2) {
        return new SearchFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // You can handle any logic here that should run before view creation
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // ViewBinding setup
        binding = FragmentSearchBinding.inflate(inflater, container, false);

        // Show all items initially
        showAllMenu();

        // Initialize adapter with filtered data
        adapter = new MenuAdapter(filteredMenuFoodName, filteredMenuItemPrice, filteredMenuImage);

        // Set layout manager
        binding.MenuRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        // Set adapter to RecyclerView
        binding.MenuRecyclerView.setAdapter(adapter);

        // Setup SearchView listener
        setupSearchView();

        // Return the fragment view
        return binding.getRoot();
    }

    // Display all menu items
    private void showAllMenu() {
        filteredMenuFoodName.clear();
        filteredMenuItemPrice.clear();
        filteredMenuImage.clear();

        filteredMenuFoodName.addAll(originalMenuFoodName);
        filteredMenuItemPrice.addAll(originalMenuItemPrice);
        filteredMenuImage.addAll(originalMenuImage);
    }

    // Configure search functionality
    private void setupSearchView() {
        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filterMenuItems(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterMenuItems(newText);
                return true;
            }
        });
    }

    // Filter menu items based on search query
    private void filterMenuItems(String query) {
        filteredMenuFoodName.clear();
        filteredMenuItemPrice.clear();
        filteredMenuImage.clear();

        for (int i = 0; i < originalMenuFoodName.size(); i++) {
            String foodName = originalMenuFoodName.get(i);
            if (foodName.toLowerCase().contains(query.toLowerCase())) {
                filteredMenuFoodName.add(foodName);
                filteredMenuItemPrice.add(originalMenuItemPrice.get(i));
                filteredMenuImage.add(originalMenuImage.get(i));
            }
        }

        adapter.notifyDataSetChanged();
    }
}
