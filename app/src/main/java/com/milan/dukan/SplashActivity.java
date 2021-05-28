package com.milan.dukan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIMEOUT = 2100;

    // UI
    ImageView ivLogo;
    TextView tvWelcomeMsg, tvTitle;

    // vars
    Animation topAnim, bottomAnim;
    Handler mHandler;
    Runnable mRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ivLogo = findViewById(R.id.splash_logo);
        tvWelcomeMsg = findViewById(R.id.splash_welcome_message);
        tvTitle = findViewById(R.id.splash_title);

        setAnimation();

        mHandler = new Handler();
        mRunnable = () -> {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        };
    }

    private void setAnimation() {
        // load animation from xml
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        ivLogo.setAnimation(topAnim);
        tvWelcomeMsg.setAnimation(bottomAnim);
        tvTitle.setAnimation(bottomAnim);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mHandler.postDelayed(mRunnable, SPLASH_TIMEOUT);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mHandler.removeCallbacks(mRunnable);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mHandler.removeCallbacks(mRunnable);
        mHandler.postDelayed(mRunnable, SPLASH_TIMEOUT);
    }
}