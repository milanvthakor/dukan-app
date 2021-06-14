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

public class CatProductRecyclerAdapter extends RecyclerView.Adapter<CatProductRecyclerAdapter.CatProductRecyclerViewHolder> {

    // vars
    private final ArrayList<Product> mProducts;
    private final OnCatProductClickListener mOnCatProductClickListener;

    public CatProductRecyclerAdapter(ArrayList<Product> mProducts, OnCatProductClickListener mOnCatProductClickListener) {
        this.mProducts = mProducts;
        this.mOnCatProductClickListener = mOnCatProductClickListener;
    }

    @NonNull
    @Override
    public CatProductRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_cat_product_list_item, parent, false);
        return new CatProductRecyclerViewHolder(view, mOnCatProductClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CatProductRecyclerViewHolder holder, int position) {
        Product product = mProducts.get(position);
        holder.tvCatProductTitle.setText(product.getTitle());
        holder.tvCatProductDesc.setText(product.getDescription());
        String price = "Rs. " + product.getPrice().toString();
        holder.tvCatProductPrice.setText(price);
        Glide.with(holder.itemView)
                .load(product.getImageUrl())
                .into(holder.ivCatProductImage);
    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }

    public interface OnCatProductClickListener {
        void onCatProductClick(int position);
    }

    public class CatProductRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        // UI Components
        ImageView ivCatProductImage;
        TextView tvCatProductTitle, tvCatProductDesc, tvCatProductPrice;

        // vars
        OnCatProductClickListener onCatProductClickListener;

        public CatProductRecyclerViewHolder(@NonNull View itemView, OnCatProductClickListener onCatProductClickListener) {
            super(itemView);

            this.onCatProductClickListener = onCatProductClickListener;

            ivCatProductImage = itemView.findViewById(R.id.cat_product_image);
            tvCatProductTitle = itemView.findViewById(R.id.cat_product_title);
            tvCatProductDesc = itemView.findViewById(R.id.cat_product_description);
            tvCatProductPrice = itemView.findViewById(R.id.cat_product_price);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onCatProductClickListener.onCatProductClick(getAdapterPosition());
        }
    }
}
