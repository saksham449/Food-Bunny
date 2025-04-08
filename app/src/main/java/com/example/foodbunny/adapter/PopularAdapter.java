package com.example.foodbunny.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodbunny.databinding.PopularItemsBinding;

import java.util.List;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.PopularViewHolder> {

    // Declare lists for food names, prices, and image resource IDs
    private List<String> items;
    private List<String> price;
    private List<Integer> image;

    // Constructor
    public PopularAdapter(List<String> items, List<String> price, List<Integer> image) {
        this.items = items;
        this.price = price;
        this.image = image;
    }

    @NonNull
    @Override
    public PopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate layout using view binding
        PopularItemsBinding binding = PopularItemsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PopularViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularViewHolder holder, int position) {
        // Get values from the list
        String item = items.get(position);
        String itemPrice = price.get(position);
        int itemImage = image.get(position);

        // Bind data to views
        holder.bind(item, itemPrice, itemImage);
    }

    @Override
    public int getItemCount() {
        return items.size(); // Return number of items
    }

    // ViewHolder class
    public static class PopularViewHolder extends RecyclerView.ViewHolder {
        PopularItemsBinding binding;

        public PopularViewHolder(PopularItemsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        // Method to bind data to layout views
        public void bind(String itemName, String itemPrice, int imageResId) {
            binding.FoodNamePopular.setText(itemName);      // Set food name
            binding.PricePopular.setText(itemPrice);        // Set price
            binding.imageView5.setImageResource(imageResId); // Set image
        }
    }
}
