package com.milan.dukan.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.milan.dukan.R;
import com.milan.dukan.models.Category;

import java.util.ArrayList;

public class CategoryRecyclerAdapter extends RecyclerView.Adapter<CategoryRecyclerAdapter.CategoryRecyclerViewHolder> {

    // vars
    private Context context;
    private ArrayList<Category> mCategories;

    public CategoryRecyclerAdapter(Context context, ArrayList<Category> mCategories) {
        this.context = context;
        this.mCategories = mCategories;
    }

    @NonNull
    @Override
    public CategoryRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_category_list_item, parent, false);
        return new CategoryRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryRecyclerViewHolder holder, int position) {
        Category category = mCategories.get(position);
        holder.tvCategoryName.setText(category.getName());
        // get the drawable file id based on name
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier(category.getImageUrl(), "drawable", context.getPackageName());
        Glide.with(holder.itemView)
                .load(resourceId)
                .into(holder.ivCategoryImage);
    }

    @Override
    public int getItemCount() {
        return mCategories.size();
    }

    public class CategoryRecyclerViewHolder extends RecyclerView.ViewHolder {

        ImageView ivCategoryImage;
        TextView tvCategoryName;

        public CategoryRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            ivCategoryImage = itemView.findViewById(R.id.category_image);
            tvCategoryName = itemView.findViewById(R.id.category_name);
        }
    }
}
