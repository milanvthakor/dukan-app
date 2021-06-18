package com.milan.dukan;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.milan.dukan.api.AuthResponse;
import com.milan.dukan.api.RetrofitClient;
import com.milan.dukan.utils.Constants;
import com.milan.dukan.views.BaseActivity;
import com.milan.dukan.views.CustomTextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity {

    private static final String TAG = "LoginActivity";

    // UI
    EditText etEmail, etPassword;
    CustomTextInputLayout tilEmail, tilPassword;
    Button btnLogin;
    TextView tvForgotPassword, tvSignUp;

    // vars
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sp = getSharedPreferences(Constants.APP_PREFERENCE_NAME, Context.MODE_PRIVATE);

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
        btnLogin.setOnClickListener(v -> validateData());
        tvSignUp.setOnClickListener(v -> navigate(RegisterActivity.class));
    }

    private void validateData() {
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
            login(email, password);
        }
    }

    private void login(String email, String password) {
        Call<AuthResponse> authResponseCall = RetrofitClient.getInstance().getAuthApi().login(email, password);
        authResponseCall.enqueue(new Callback<AuthResponse>() {
            @Override
            public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                AuthResponse authResponse = response.body();
                if (authResponse != null) {
                    displayToast(authResponse.getMessage());
                    if (authResponse.getResponse().equals("Success")) {
                        SharedPreferences.Editor spEditor = sp.edit();
                        spEditor.putString(Constants.APP_PREFERENCE_USER_EMAIL, authResponse.getEmail());
                        spEditor.putString(Constants.APP_PREFERENCE_USER_PK, authResponse.getPk().toString());
                        spEditor.putString(Constants.APP_PREFERENCE_USER_TOKEN, authResponse.getToken());
                        spEditor.apply();
                        spEditor.commit();
                        navigate(MainActivity.class);
                        finish();
                    }
                } else {
                    displayToast("Something went wrong!!");
                }
            }

            @Override
            public void onFailure(Call<AuthResponse> call, Throwable t) {
                displayToast(t.getLocalizedMessage());
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}