package com.milan.dukan.views;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.textfield.TextInputLayout;

public class CustomTextInputLayout extends TextInputLayout {
    public CustomTextInputLayout(@NonNull Context context) {
        super(context);
    }

    public CustomTextInputLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomTextInputLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        watcherToRemoveError();
    }

    // remove error from the layout when anything gets written down
    private void watcherToRemoveError() {
        EditText editText = getEditText();
        if (editText != null) {
            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    clearError();
                }
            });
        }
    }

    // enable error display functionality and display error
    public void showError(String errorMsg) {
        setErrorEnabled(true);
        setError(errorMsg);
    }

    // clear the error and remove the error space
    public void clearError() {
        setError(null);
        setErrorEnabled(false);
    }
}
