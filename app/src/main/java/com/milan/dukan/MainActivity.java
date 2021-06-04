package com.milan.dukan;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.milan.dukan.adapters.ProductRecyclerAdapter;
import com.milan.dukan.models.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // UI Components
    RecyclerView rvProducts;

    // vars
    private ArrayList<Product> mProduct = new ArrayList<>();
    private ProductRecyclerAdapter mProductRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();

        insertFakeProducts();
        initRecyclerView();
    }

    private void bindViews() {
        rvProducts = findViewById(R.id.main_products);
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
            } else if (i % 4 == 3) {
                product.setImageUrl("https://images.unsplash.com/photo-1513116476489-7635e79feb27?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTh8fHByb2R1Y3R8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60");
            }
            mProduct.add(product);
        }
    }
}