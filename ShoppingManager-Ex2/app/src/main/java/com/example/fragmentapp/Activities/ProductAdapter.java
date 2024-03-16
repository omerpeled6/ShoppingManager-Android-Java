package com.example.fragmentapp.Activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentapp.Data.Products;
import com.example.fragmentapp.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private List<Products> ProductList;
    private Context context;
    // Maintain the amount of each grocery item
    private Map<Integer, Integer> ProductAmount = new HashMap<>();

    public ProductAdapter(Context context, List<Products> ProductList) {
        this.context = context;
        this.ProductList = ProductList;
        // Initialize all amounts to 0
        for (int i = 0; i < ProductList.size(); i++) {
            ProductAmount.put(i, 0);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        Products product = ProductList.get(position);
        holder.pName.setText(product.getName());
        holder.imageView.setImageResource(product.getImage());
        holder.pAmount.setText(String.valueOf(ProductAmount.get(position)));

        holder.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductAmount.put(position, ProductAmount.get(position) + 1);
                holder.pAmount.setText(String.valueOf(ProductAmount.get(position)));
            }
        });

        holder.removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int amount = ProductAmount.get(position);
                if (amount > 0) {
                    ProductAmount.put(position, amount - 1);
                    holder.pAmount.setText(String.valueOf(ProductAmount.get(position)));
                }
            }
        });

        holder.clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductAmount.put(position, 0);
                holder.pAmount.setText("0");
            }
        });
    }

    @Override
    public int getItemCount() {
        return ProductList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView pName;
        TextView pAmount;
        Button addButton;
        Button removeButton;
        Button clearButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            pName = itemView.findViewById(R.id.pName);
            pAmount = itemView.findViewById(R.id.pAmount);
            addButton = itemView.findViewById(R.id.add_button);
            removeButton = itemView.findViewById(R.id.remove_button);
            clearButton = itemView.findViewById(R.id.clear_button);
        }
    }
}