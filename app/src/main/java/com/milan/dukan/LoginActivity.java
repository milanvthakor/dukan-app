package com.milan.dukan;

import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.milan.dukan.views.BaseActivity;
import com.milan.dukan.views.CustomTextInputLayout;

public class LoginActivity extends BaseActivity {

    // UI
    EditText etEmail, etPassword;
    CustomTextInputLayout tilEmail, tilPassword;
    Button btnLogin;
    TextView tvForgotPassword, tvSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // to remove flash in transition animation
        getWindow().setEnterTransition(null);

        bindViews();
        setListeners();
    }

    private void bindViews() {
        etEmail = findViewById(R.id.login_email);
        etPassword = findViewById(R.id.login_password);
        tilEmail = findViewById(R.id.login_email_layout);
        tilPassword = findViewById(R.id.login_password_layout);
        btnLogin = findViewById(R.id.login);
        tvForgotPassword = findViewById(R.id.login_forgot_password);
        tvSignUp = findViewById(R.id.login_sign_up);
    }

    private void setListeners() {
        btnLogin.setOnClickListener(v -> login());
        tvSignUp.setOnClickListener(v -> navigate(RegisterActivity.class));
    }

    private void login() {
        String email, password;
        email = etEmail.getText().toString().trim();
        password = etPassword.getText().toString().trim();

        if (email.isEmpty()) {
            tilEmail.showError("Email required");
            etEmail.requestFocus();
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            tilEmail.showError("Invalid email");
            etEmail.requestFocus();
        } else if (password.isEmpty()) {
            tilPassword.showError("Password required");
            etPassword.requestFocus();
        } else if (password.length() < 8 || password.length() > 12) {
            tilPassword.showError("Password length must be between 8 to 12");
            etPassword.requestFocus();
        } else {
            if (email.equals("admin@gmail.com") && password.equals("admin123")) {
                displayToast("Signed In Successfully");
                navigate(MainActivity.class);
                finish();
            } else {
                displayToast("Wrong Credentials!!");
            }
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}