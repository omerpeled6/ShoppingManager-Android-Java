package com.example.fragmentapp.Fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fragmentapp.Activities.ProductAdapter;
import com.example.fragmentapp.Data.Products;
import com.example.fragmentapp.R;

public class ProdcutManagerFragment extends Fragment {

    public ProdcutManagerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_page, container, false);

        // Ensure the key here matches what was used in SignInFragment
        String usernameBundle = getArguments().getString("username", "User"); // Added a default value

        TextView title = view.findViewById(R.id.TextViewUsername);
        title.setText("Hello " + usernameBundle + "!");

        // Inside MainPageFragment, after setting the username text

        RecyclerView recyclerView = view.findViewById(R.id.res);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

// Assuming Groceries.getGroceryList() returns a list of all groceries
        ProductAdapter adapter = new ProductAdapter(getActivity(), Products.getProductList());
        recyclerView.setAdapter(adapter);


        return view;
    }
}
