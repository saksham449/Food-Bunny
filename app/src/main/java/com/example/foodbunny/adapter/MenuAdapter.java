package com.example.foodbunny.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.foodbunny.databinding.MenuItemBinding;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private List<String> menuItemsName;
    private List<String> menuItemPrices;
    private List<Integer> menuImages;

    // Constructor to initialize data
    public MenuAdapter(List<String> menuItemsName, List<String> menuItemPrices, List<Integer> menuImages) {
        this.menuItemsName = menuItemsName;
        this.menuItemPrices = menuItemPrices;
        this.menuImages = menuImages;
    }

    // Called when RecyclerView needs a new ViewHolder
    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout using ViewBinding
        MenuItemBinding binding = MenuItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MenuViewHolder(binding);
    }

    // Binds data to the views for a specific position
    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        holder.bind(position);
    }

    // Returns the total number of items
    @Override
    public int getItemCount() {
        return menuItemsName.size();
    }

    // ViewHolder class to hold references to the layout views
    class MenuViewHolder extends RecyclerView.ViewHolder {
        private MenuItemBinding binding;

        // Constructor
        public MenuViewHolder(@NonNull MenuItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        // Binds the data for the given position
        public void bind(int position) {
            binding.menuFoodName.setText(menuItemsName.get(position));       // Set food name
            binding.menuPrice.setText(menuItemPrices.get(position));         // Set price
            binding.menuImage.setImageResource(menuImages.get(position));    // Set image
        }
    }
}
