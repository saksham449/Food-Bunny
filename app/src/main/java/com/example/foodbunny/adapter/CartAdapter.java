package com.example.foodbunny.adapter;

// Importing necessary Android and RecyclerView classes
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

// Importing view binding for cart item layout
import com.example.foodbunny.databinding.CartItemBinding;

// Importing list to handle multiple items
import java.util.List;

// Adapter class to handle and display cart items in RecyclerView
public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    // Variables to hold food names, prices, and images
    private List<String> cartItems;
    private List<String> cartItemPrice;
    private List<Integer> cartImage;

    // Array to track quantity of each item (default 1 for all)
    private int[] itemQuantities;

    // Constructor to initialize adapter with data
    public CartAdapter(List<String> cartItems, List<String> cartItemPrice, List<Integer> cartImage) {
        this.cartItems = cartItems;
        this.cartItemPrice = cartItemPrice;
        this.cartImage = cartImage;

        // Initialize all item quantities to 1
        this.itemQuantities = new int[cartItems.size()];
        for (int i = 0; i < itemQuantities.length; i++) {
            itemQuantities[i] = 1;
        }
    }

    // Called when RecyclerView needs a new ViewHolder
    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CartItemBinding binding = CartItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CartViewHolder(binding);
    }

    // Called to display the data at the specified position
    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        holder.bind(position);
    }

    // Return total number of items
    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    // ViewHolder class to hold views for each cart item
    class CartViewHolder extends RecyclerView.ViewHolder {

        private final CartItemBinding binding;

        // Constructor for CartViewHolder
        public CartViewHolder(CartItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        // Method to bind data to each cart item view
        public void bind(int position) {
            int quantity = itemQuantities[position];

            // Set food name, price, image, and quantity
            binding.cartFoodName.setText(cartItems.get(position));
            binding.cartItemprice.setText(cartItemPrice.get(position));
            binding.cartImage.setImageResource(cartImage.get(position));
            binding.cartitemquantity.setText(String.valueOf(quantity));

            // PLUS Button - Increase quantity
            binding.plusbutton.setOnClickListener(v -> {
                if (itemQuantities[position] < 10) { // Set max limit if needed
                    itemQuantities[position]++;
                    notifyItemChanged(position);
                }
            });

            // MINUS Button - Decrease quantity
            binding.minusbutton.setOnClickListener(v -> {
                if (itemQuantities[position] > 1) { // Minimum quantity 1
                    itemQuantities[position]--;
                    notifyItemChanged(position);
                }
            });

            // DELETE Button - Remove item from cart
            binding.deleteButton.setOnClickListener(v -> {
                int pos = getAdapterPosition();
                if (pos != RecyclerView.NO_POSITION) {
                    cartItems.remove(pos);
                    cartItemPrice.remove(pos);
                    cartImage.remove(pos);

                    // Update quantities array after deletion
                    int[] newQuantities = new int[itemQuantities.length - 1];
                    int index = 0;
                    for (int i = 0; i < itemQuantities.length; i++) {
                        if (i != pos) {
                            newQuantities[index++] = itemQuantities[i];
                        }
                    }
                    itemQuantities = newQuantities;

                    notifyItemRemoved(pos);
                    notifyItemRangeChanged(pos, cartItems.size());
                }
            });
        }
    }
}
