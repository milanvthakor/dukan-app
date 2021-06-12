package com.milan.dukan.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.milan.dukan.R;
import com.milan.dukan.models.Product;

import java.util.ArrayList;

public class ProductRecyclerAdapter extends RecyclerView.Adapter<ProductRecyclerAdapter.ProductRecyclerViewHolder> implements Filterable {

    // vars
    private ArrayList<Product> mProducts;
    private ArrayList<Product> mProductsFiltered;
    private OnProductListChangedListener mOnProductListChangedListener;

    public ProductRecyclerAdapter(ArrayList<Product> mProducts, OnProductListChangedListener mOnProductListChangedListener) {
        this.mProducts = mProducts;
        this.mProductsFiltered = mProducts;
        this.mOnProductListChangedListener = mOnProductListChangedListener;
    }

    @NonNull
    @Override
    public ProductRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_product_list_item, parent, false);
        return new ProductRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductRecyclerViewHolder holder, int position) {
        Product product = mProductsFiltered.get(position);
        holder.tvProductTitle.setText(product.getTitle());
        String price = "Rs. " + product.getPrice().toString();
        holder.tvProductPrice.setText(price);
        Glide.with(holder.itemView)
                .load(product.getImageUrl())
                .into(holder.ivProductImage);
    }

    @Override
    public int getItemCount() {
        return mProductsFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                // this will perform in worker thread asynchronously

                String query = constraint.toString();
                if (query.isEmpty()) {
                    mProductsFiltered = mProducts;
                } else {
                    ArrayList<Product> filteredProducts = new ArrayList<>();
                    for (Product product : mProducts) {
                        if (product.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                                product.getDescription().toLowerCase().contains(query.toLowerCase())) {
                            filteredProducts.add(product);
                        }
                    }
                    mProductsFiltered = filteredProducts;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mProductsFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                // this will perform in UI thread

                mProductsFiltered = (ArrayList<Product>) results.values;
                notifyDataSetChanged();
                mOnProductListChangedListener.onProductListChanged();
            }
        };
    }

    public interface OnProductListChangedListener {
        void onProductListChanged();
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
