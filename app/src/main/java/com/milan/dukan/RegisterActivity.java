package com.milan.dukan;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.milan.dukan.models.User;
import com.milan.dukan.views.BaseActivity;
import com.milan.dukan.views.CustomTextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class RegisterActivity extends BaseActivity implements DatePickerDialog.OnDateSetListener {

    private static final String TAG = "RegisterActivity";

    private static final Calendar mCalender = Calendar.getInstance();
    private static final String dateFormat = "dd/MM/yy";
    private static final SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.US);

    // UI
    EditText etName, etDob, etEmail, etContactNo, etPassword, etCfmPassword;
    CustomTextInputLayout tilName, tilDob, tilEmail, tilContactNo, tilCity, tilPassword, tilCfmPassword;
    AutoCompleteTextView actCity;
    RadioGroup rgGender;
    RadioButton rbGender;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        bindViews();

        // populate city spinner
        ArrayAdapter<String> mCityAdapter = new ArrayAdapter<>(this,
                R.layout.list_item,
                getResources().getStringArray(R.array.india_top_places));
        actCity.setAdapter(mCityAdapter);

        setListener();
    }

    private void bindViews() {
        etName = findViewById(R.id.register_name);
        etDob = findViewById(R.id.register_dob);
        etEmail = findViewById(R.id.register_email);
        etContactNo = findViewById(R.id.register_contact_no);
        actCity = findViewById(R.id.register_city);
        etPassword = findViewById(R.id.register_password);
        etCfmPassword = findViewById(R.id.register_confirm_password);
        tilName = findViewById(R.id.register_name_layout);
        tilDob = findViewById(R.id.register_dob_layout);
        tilEmail = findViewById(R.id.register_email_layout);
        tilContactNo = findViewById(R.id.register_contact_no_layout);
        tilCity = findViewById(R.id.register_city_layout);
        tilPassword = findViewById(R.id.register_password_layout);
        tilCfmPassword = findViewById(R.id.register_confirm_password_layout);
        rgGender = findViewById(R.id.register_gender);
        btnRegister = findViewById(R.id.register);
    }

    private void setListener() {
        etDob.setOnClickListener(v -> {
            DatePickerDialog dpd = new DatePickerDialog(this,
                    this,
                    mCalender.get(Calendar.YEAR),
                    mCalender.get(Calendar.MONTH),
                    mCalender.get(Calendar.DAY_OF_MONTH)
            );
            dpd.getDatePicker().setMaxDate(System.currentTimeMillis()); // future dates are not allowed to set
            dpd.show();
        });
        btnRegister.setOnClickListener(v -> register());
    }

    private void register() {
        String name, gender, dob, email, contactNo, city, password, cfmPassword;
        int selectedRadioBtnId = rgGender.getCheckedRadioButtonId();
        rbGender = findViewById(selectedRadioBtnId);

        name = etName.getText().toString().trim();
        gender = selectedRadioBtnId != -1 ? rbGender.getText().toString().trim() : "";
        dob = etDob.getText().toString().trim();
        email = etEmail.getText().toString().trim();
        contactNo = etContactNo.getText().toString().trim();
        city = actCity.getText().toString().trim();
        password = etPassword.getText().toString().trim();
        cfmPassword = etCfmPassword.getText().toString().trim();

        if (name.isEmpty()) {
            tilName.showError("Name required");
            etName.requestFocus();
        } else if (dob.isEmpty()) {
            tilDob.showError("Date of Birth required");
            etDob.requestFocus();
        } else if (email.isEmpty()) {
            tilEmail.showError("Email required");
            etEmail.requestFocus();
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            tilEmail.showError("Invalid email");
            etEmail.requestFocus();
        } else if (contactNo.isEmpty()) {
            tilContactNo.showError("Contact No required");
            etContactNo.requestFocus();
        } else if (contactNo.length() != 10) {
            tilContactNo.showError("Contact No must have 10 digits");
            etContactNo.requestFocus();
        } else if (city.isEmpty()) {
            tilCity.showError("City required");
            actCity.requestFocus();
        } else if (password.isEmpty()) {
            tilPassword.showError("Password required");
            etPassword.requestFocus();
        } else if (password.length() < 8 || password.length() > 12) {
            tilPassword.showError("Password length must be between 8 to 12");
            etPassword.requestFocus();
        } else if (cfmPassword.isEmpty()) {
            tilCfmPassword.showError("Confirm the password");
            etCfmPassword.requestFocus();
        } else if (!password.equals(cfmPassword)) {
            tilCfmPassword.showError("Both passwords does not match");
            etCfmPassword.requestFocus();
        } else {
            User mUser = new User(name, dob, gender, email, contactNo, city, password);
            Log.d(TAG, "register: " + mUser.toString());

            displayToast("Signed Up Successfully");
            navigate(MainActivity.class);
            finish();
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        mCalender.set(Calendar.YEAR, year);
        mCalender.set(Calendar.MONTH, month);
        mCalender.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        // convert date into given format
        String selectedDate = sdf.format(mCalender.getTime());
        etDob.setText(selectedDate);
    }
}