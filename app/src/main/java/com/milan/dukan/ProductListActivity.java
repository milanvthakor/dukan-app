package com.milan.dukan;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.milan.dukan.adapters.CatProductRecyclerAdapter;
import com.milan.dukan.models.Category;
import com.milan.dukan.models.Product;
import com.milan.dukan.utils.Utils;

import java.util.ArrayList;

public class ProductListActivity extends AppCompatActivity implements CatProductRecyclerAdapter.OnCatProductClickListener {

    // UI Components
    RecyclerView rvCatProducts;

    // vars
    private ArrayList<Product> mCatProducts = new ArrayList<>();
    private CatProductRecyclerAdapter mCatProductRecyclerAdapter;
    private Category mCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        // set custom toolbar as support action bar to activity
        setSupportActionBar(findViewById(R.id.product_list_toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);

        getIncomingIntent();
        bindViews();

        filterProductListCategoryWise();
        initRecyclerView();
    }

    private void bindViews() {
        rvCatProducts = findViewById(R.id.product_list);
    }

    private void getIncomingIntent() {
        if (getIntent().hasExtra("selected_category")) {
            mCategory = getIntent().getParcelableExtra("selected_category");
            setTitle(mCategory.getName());
        }
    }

    private void initRecyclerView() {
        mCatProductRecyclerAdapter = new CatProductRecyclerAdapter(mCatProducts, this);
        rvCatProducts.setAdapter(mCatProductRecyclerAdapter);
    }

    private void filterProductListCategoryWise() {
        ArrayList<Product> allProducts = Utils.insertFakeProducts();

        if (mCategory != null) {
            for (Product product : allProducts) {
                if (product.getCategoryId().equals(mCategory.getId())) {
                    mCatProducts.add(product);
                }
            }
        } else {
            mCatProducts = allProducts;
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCatProductClick(int position) {
        Product product = mCatProducts.get(position);
        Intent intent = new Intent(this, ProductDetailsActivity.class);
        intent.putExtra("selected_product", product);
        if (mCategory != null) {
            intent.putExtra("selected_category", mCategory);
        }
        startActivity(intent);
    }
}