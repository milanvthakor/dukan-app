package com.milan.dukan;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.milan.dukan.models.Category;
import com.milan.dukan.models.Product;

import java.util.Objects;

public class ProductDetailsActivity extends AppCompatActivity {

    // UI Components
    ImageView ivProductImage;
    TextView tvProductTitle, tvProductPrice, tvProductDescription;

    // vars
    private Product mProduct;
    private Category mCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        // set custom toolbar as support action bar to activity
        setSupportActionBar(findViewById(R.id.product_details_toolbar));
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);

        bindViews();
        getIncomingIntent();

        if (mCategory != null) {
            getSupportActionBar().setTitle(mCategory.getName());
        }

        setProductInfo();
    }

    private void bindViews() {
        ivProductImage = findViewById(R.id.product_details_image);
        tvProductTitle = findViewById(R.id.product_details_title);
        tvProductPrice = findViewById(R.id.product_details_price);
        tvProductDescription = findViewById(R.id.product_details_description);
    }

    private void getIncomingIntent() {
        if (getIntent().hasExtra("selected_product")) {
            mProduct = getIntent().getParcelableExtra("selected_product");
        }
        if (getIntent().hasExtra("selected_category")) {
            mCategory = getIntent().getParcelableExtra("selected_category");
        }
    }

    private void setProductInfo() {
        Glide.with(this)
                .load(mProduct.getImageUrl())
                .into(ivProductImage);
        tvProductTitle.setText(mProduct.getTitle());
        String price = "Rs. " + mProduct.getPrice().toString();
        tvProductPrice.setText(price);
        tvProductDescription.setText(mProduct.getDescription());
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
}