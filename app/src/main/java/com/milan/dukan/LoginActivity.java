package com.milan.dukan;

import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends BaseActivity {

    // UI
    EditText etEmail, etPassword;
    TextInputLayout etEmailLayout, etPasswordLayout;
    Button btnLogin;
    TextView tvForgotPassword, tvSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // to remove flash in transition animation
        getWindow().setEnterTransition(null);

        etEmail = findViewById(R.id.login_email);
        etPassword = findViewById(R.id.login_password);
        etEmailLayout = findViewById(R.id.login_email_layout);
        etPasswordLayout = findViewById(R.id.login_password_layout);
        btnLogin = findViewById(R.id.login);
        tvForgotPassword = findViewById(R.id.login_forgot_password);
        tvSignUp = findViewById(R.id.login_sign_up);

        btnLogin.setOnClickListener(v -> login());
    }

    private void login() {
        String email, password;
        email = etEmail.getText().toString().trim();
        password = etPassword.getText().toString().trim();

        if (email.isEmpty()) {
            etEmailLayout.setError("Email required");
            etEmail.requestFocus();
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmailLayout.setError("Invalid email");
            etEmail.requestFocus();
        } else if (password.isEmpty()) {
            etPasswordLayout.setError("Password required");
            etPassword.requestFocus();
        } else if (password.length() < 8 || password.length() > 12) {
            etPasswordLayout.setError("Password length must be between 8 to 12");
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