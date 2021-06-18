package com.milan.dukan;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.milan.dukan.adapters.SettingsCollectionAdapter;

import java.util.Objects;

public class SettingsActivity extends AppCompatActivity {

    // UI Components
    TabLayout tabLayout;
    ViewPager2 viewPager;

    // vars
    SettingsCollectionAdapter mSettingsCollectionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // set custom toolbar as support action bar to activity
        setSupportActionBar(findViewById(R.id.settings_toolbar));
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);

        bindViews();
        initViewPager();
    }

    private void bindViews() {
        tabLayout = findViewById(R.id.settings_tab_layout);
        viewPager = findViewById(R.id.settings_view_pager);
    }

    private void initViewPager() {
        mSettingsCollectionAdapter = new SettingsCollectionAdapter(this);
        viewPager.setAdapter(mSettingsCollectionAdapter);
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            if (position == 0) {
                tab.setText(getString(R.string.my_profile));
            } else {
                tab.setText(getString(R.string.notifications));
            }
        }).attach();
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