package com.milan.dukan;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends BaseActivity {

    // UI
    ImageView ivLogo;
    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // to remove flash in transition animation
        getWindow().setEnterTransition(null);

        ivLogo = findViewById(R.id.login_logo);
        tvTitle = findViewById(R.id.login_title);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}