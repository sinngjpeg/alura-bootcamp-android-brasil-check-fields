package com.sinngjpeg.alurafood.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;
import com.sinngjpeg.alurafood.R;

public class FormularioCadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_cadastro);

        initializerFields();

    }

    private void initializerFields() {
        configureFieldFullName();
        configureFieldCPF();
        configureFieldPhone();
        configureFieldEmail();
        configureFieldPassword();
    }

    private void configureFieldPassword() {
        TextInputLayout textInputPassword = findViewById(R.id.edt_password);
        addValidateField(textInputPassword);
    }

    private void configureFieldEmail() {
        TextInputLayout textInputEmail = findViewById(R.id.edt_email);
        addValidateField(textInputEmail);
    }

    private void configureFieldPhone() {
        TextInputLayout textInputPhone = findViewById(R.id.edt_phone);
        addValidateField(textInputPhone);
    }

    private void configureFieldCPF() {
        TextInputLayout textInputCpf = findViewById(R.id.edt_cpf);

        EditText fieldCPF = textInputCpf.getEditText();
        fieldCPF.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                String cpf = fieldCPF.getText().toString();
                if (!hasFocus) {
                    if (!validateMandatoryField(cpf, textInputCpf)) return;
                    if (validateFieldWith11Digits(cpf, textInputCpf)) return;
                    removeError(textInputCpf);
                }
            }
        });
    }

    private void removeError(TextInputLayout textInputCpf) {
        textInputCpf.setError(null);
        textInputCpf.setErrorEnabled(false);
    }

    private boolean validateFieldWith11Digits(String cpf, TextInputLayout textInputCpf) {
        if (cpf.length() != 11) {
            textInputCpf.setError("O CPF precisa ter 11 digitos");
            return false;
        }
        return true;
    }


    private void configureFieldFullName() {
        TextInputLayout textInputFullName = findViewById(R.id.edt_full_name);
        addValidateField(textInputFullName);
    }

    private void addValidateField(final TextInputLayout textInputField) {
        final EditText field = textInputField.getEditText();
        field.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                String text = field.getText().toString();
                if (!hasFocus) {
                    if (!validateMandatoryField(text, textInputField)) return;
                    removeError(textInputField);
                }
            }
        });
    }

    private boolean validateMandatoryField(String text, TextInputLayout textInputField) {
        if (text.isEmpty()) {
            textInputField.setError("Campo obrigatorio");
            return false;
        }
        return true;
    }
}