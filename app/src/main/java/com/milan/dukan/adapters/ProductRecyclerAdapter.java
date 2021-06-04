package com.milan.dukan.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.milan.dukan.R;
import com.milan.dukan.models.Product;

import java.util.ArrayList;

public class ProductRecyclerAdapter extends RecyclerView.Adapter<ProductRecyclerAdapter.ProductRecyclerViewHolder> {

    private ArrayList<Product> mProducts;

    public ProductRecyclerAdapter(ArrayList<Product> mProducts) {
        this.mProducts = mProducts;
    }

    @NonNull
    @Override
    public ProductRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_product_list_item, parent, false);
        return new ProductRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductRecyclerViewHolder holder, int position) {
        Product product = mProducts.get(position);
        holder.tvProductTitle.setText(product.getTitle());
        String price = "Rs. " + product.getPrice().toString();
        holder.tvProductPrice.setText(price);
        Glide.with(holder.itemView)
                .load(product.getImageUrl())
                .into(holder.ivProductImage);
    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }

    public class ProductRecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView tvProductTitle, tvProductPrice;
        ImageView ivProductImage;

        public ProductRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            tvProductTitle = itemView.findViewById(R.id.product_title);
            tvProductPrice = itemView.findViewById(R.id.product_price);
            ivProductImage = itemView.findViewById(R.id.product_image);
        }
    }
}
