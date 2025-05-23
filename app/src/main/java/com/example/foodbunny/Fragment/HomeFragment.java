package com.example.foodbunny.Fragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.example.foodbunny.LoginActivity;
import com.example.foodbunny.R;
import com.example.foodbunny.SignActivity;
import com.example.foodbunny.adapter.PopularAdapter;
import com.example.foodbunny.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        // ❌ POTENTIAL ISSUE:
        // Using getParentFragmentManager() might not work properly if this fragment is nested.
        // In that case, use getChildFragmentManager() instead.

        // ❌ ANOTHER POSSIBLE CAUSE OF CRASH:
        // If you press the button multiple times quickly, the bottom sheet tries to open again
        // while it's still being displayed — this causes an IllegalStateException: "Fragment already added".

        // ✅ FIX: Use newInstance() method and optional null-check before showing
        binding.viewAllMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ❌ You created it directly (not using newInstance()), which is fine,
                // but could lead to problems if later arguments or state handling is needed.

                MenuBottomSheetFragment bottomSheetDialog = new MenuBottomSheetFragment();

                // ❌ This line works ONLY if the fragment isn't nested.
                // ✅ FIX: Use getChildFragmentManager() if needed or add a tag check.

                bottomSheetDialog.show(getParentFragmentManager(), "test");
                // Use: getChildFragmentManager() if nested
                // Add null-check: if (getParentFragmentManager().findFragmentByTag("test") == null)
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Image slider setup
        ArrayList<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.banner1, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner2, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner3, ScaleTypes.FIT));
        ImageSlider imageSlider = binding.imageSlider;
        imageSlider.setImageList(imageList);

        // RecyclerView data
        List<String> foodName = Arrays.asList("Burger", "Sandwich", "Momo", "Item","Burger", "Sandwich", "Momo", "Item");
        List<String> price = Arrays.asList("$5", "$7", "$8", "$10","$5", "$7", "$8", "$10");
        List<Integer> populerFoodImages = Arrays.asList(
                R.drawable.menu1,
                R.drawable.menu2,
                R.drawable.menu3,
                R.drawable.menu4,
                R.drawable.menu1,
                R.drawable.menu2,
                R.drawable.menu3,
                R.drawable.menu4
        );

        // Adapter setup
        PopularAdapter adapter = new PopularAdapter(foodName, price, populerFoodImages);
        binding.PopularRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.PopularRecyclerView.setAdapter(adapter);
    }
}
