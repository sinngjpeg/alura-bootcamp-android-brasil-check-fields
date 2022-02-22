package com.sinngjpeg.alurafood.ui.activities.validator;

import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class validatorFields {

    private final TextInputLayout textInputField;
    private final EditText field;

    public validatorFields(TextInputLayout textInputField) {
        this.textInputField = textInputField;
        this.field = this.textInputField.getEditText();
    }


    private boolean validateMandatoryField() {
        String text = field.getText().toString();
        if (text.isEmpty()) {
            textInputField.setError("Campo obrigatório");
            return false;
        }
        return true;
    }

    public boolean isValid(){
        if(!validateMandatoryField()) return false;
        removeError();
        return true;
    }

    private void removeError() {
        textInputField.setError(null);
        textInputField.setErrorEnabled(false);
    }
}
