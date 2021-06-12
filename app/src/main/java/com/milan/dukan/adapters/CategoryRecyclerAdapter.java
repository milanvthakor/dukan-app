package com.milan.dukan.adapters;

import android.content.Context;
import android.content.res.Resources;
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
import com.milan.dukan.models.Category;

import java.util.ArrayList;

public class CategoryRecyclerAdapter extends RecyclerView.Adapter<CategoryRecyclerAdapter.CategoryRecyclerViewHolder> implements Filterable {

    // vars
    private Context context;
    private ArrayList<Category> mCategories;
    private ArrayList<Category> mCategoriesFiltered;
    private OnCategoryListChangedListener mOnCategoryListChangedListener;
    private OnCategoryClickListener mOnCategoryClickListener;

    public CategoryRecyclerAdapter(Context context, ArrayList<Category> mCategories, OnCategoryListChangedListener mOnCategoryListChangedListener, OnCategoryClickListener mOnCategoryClickListener) {
        this.context = context;
        this.mCategories = mCategories;
        this.mCategoriesFiltered = mCategories;
        this.mOnCategoryListChangedListener = mOnCategoryListChangedListener;
        this.mOnCategoryClickListener = mOnCategoryClickListener;
    }

    @NonNull
    @Override
    public CategoryRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_category_list_item, parent, false);
        return new CategoryRecyclerViewHolder(view, mOnCategoryClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryRecyclerViewHolder holder, int position) {
        Category category = mCategoriesFiltered.get(position);
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
        return mCategoriesFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                // this will perform in worker thread asynchronously

                String query = constraint.toString();
                if (query.isEmpty()) {
                    mCategoriesFiltered = mCategories;
                } else {
                    ArrayList<Category> filteredCategories = new ArrayList<>();
                    for (Category category : mCategories) {
                        if (category.getName().toLowerCase().contains(query.toLowerCase()) ||
                                category.getDescription().toLowerCase().contains(query.toLowerCase())) {
                            filteredCategories.add(category);
                        }
                    }
                    mCategoriesFiltered = filteredCategories;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mCategoriesFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                // this will perform in UI thread

                mCategoriesFiltered = (ArrayList<Category>) results.values;
                notifyDataSetChanged();
                mOnCategoryListChangedListener.onCategoryListChanged();
            }
        };
    }

    public interface OnCategoryListChangedListener {
        void onCategoryListChanged();
    }

    public interface OnCategoryClickListener {
        void onCategoryClick(int position);
    }

    public class CategoryRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView ivCategoryImage;
        TextView tvCategoryName;
        OnCategoryClickListener onCategoryClickListener;

        public CategoryRecyclerViewHolder(@NonNull View itemView, OnCategoryClickListener onCategoryClickListener) {
            super(itemView);

            this.onCategoryClickListener = onCategoryClickListener;

            ivCategoryImage = itemView.findViewById(R.id.category_image);
            tvCategoryName = itemView.findViewById(R.id.category_name);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onCategoryClickListener.onCategoryClick(getAdapterPosition());
        }
    }
}
