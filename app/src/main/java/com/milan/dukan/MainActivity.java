package com.milan.dukan;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import com.milan.dukan.adapters.ProductRecyclerAdapter;
import com.milan.dukan.models.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    // UI Components
    RecyclerView rvProducts;
    TextView tvProductsLabel;

    // vars
    private ArrayList<Product> mProduct = new ArrayList<>();
    private ProductRecyclerAdapter mProductRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set custom toolbar as support action bar to activity
        setSupportActionBar(findViewById(R.id.main_toolbar));

        bindViews();

        insertFakeProducts();
        initRecyclerView();
    }

    private void bindViews() {
        rvProducts = findViewById(R.id.main_products);
        tvProductsLabel = findViewById(R.id.products_label);
    }

    private void initRecyclerView() {
        mProductRecyclerAdapter = new ProductRecyclerAdapter(mProduct);
        rvProducts.setAdapter(mProductRecyclerAdapter);
    }

    private void insertFakeProducts() {
        for (int i = 0; i < 100; i++) {
            Product product = new Product();
            product.setId("PRD" + i);
            product.setTitle("Product #" + i);
            product.setDescription("This is description for Product #" + i);
            product.setPrice(200.0 + i);
            if (i % 4 == 0) {
                product.setImageUrl("https://images.unsplash.com/photo-1542291026-7eec264c27ff?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=750&q=80");
            } else if (i % 4 == 1) {
                product.setImageUrl("https://images.unsplash.com/photo-1581235720704-06d3acfcb36f?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTJ8fHByb2R1Y3R8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60");
            } else if (i % 4 == 2) {
                product.setImageUrl("https://images.unsplash.com/photo-1491637639811-60e2756cc1c7?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTR8fHByb2R1Y3R8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60");
            } else {
                product.setImageUrl("https://images.unsplash.com/photo-1513116476489-7635e79feb27?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTh8fHByb2R1Y3R8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60");
            }
            mProduct.add(product);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.search);
        final SearchView searchView = (SearchView) searchItem.getActionView();
        // remove underline from search view
        searchView.findViewById(androidx.appcompat.R.id.search_plate).setBackgroundColor(Color.TRANSPARENT);
        // make search view to take entire width
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setQueryHint("Search...");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // filter recycler view when query submitted
                mProductRecyclerAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // filter recycler view when text is changed
                mProductRecyclerAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
}