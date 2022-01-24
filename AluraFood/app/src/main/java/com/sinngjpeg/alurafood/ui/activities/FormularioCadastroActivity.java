package com.sinngjpeg.alurafood.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;
import com.sinngjpeg.alurafood.R;

import org.w3c.dom.Text;

public class FormularioCadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_cadastro);

        TextInputLayout textInputFullName = findViewById(R.id.edt_full_name);
        final EditText fieldFullName = textInputFullName.getEditText();
        addValidateField(textInputFullName);

        TextInputLayout textInputCpf = findViewById(R.id.edt_cpf);
        final EditText fieldCpf = textInputCpf.getEditText();
        addValidateField(fieldCpf);

        TextInputLayout textInputPhone = findViewById(R.id.edt_phone);
        final EditText fieldPhone = textInputPhone.getEditText();
        addValidateField(fieldPhone);

        TextInputLayout textInputEmail = findViewById(R.id.edt_email);
        final EditText fieldEmail = textInputEmail.getEditText();
        addValidateField(fieldEmail);

        TextInputLayout textInputPassword = findViewById(R.id.edt_password);
        final EditText fieldPassword = textInputPassword.getEditText();
        addValidateField(fieldPassword);

    }

    private void addValidateField(final TextInputLayout textInputField) {
        final EditText field = textInputField.getEditText();
        field.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                String text = field.getText().toString();
                if (!hasFocus) {
                    if (text.isEmpty()) {
                        textInputField.setError("Campo Obrigatorio");
                    } else {
                        textInputField.setError(null);
                        textInputField.setErrorEnabled(false);
                    }
                }
            }
        });
    }

    private void addValidateField(final EditText field) {
        field.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                String text = field.getText().toString();
                if (!hasFocus) {
                    if (text.isEmpty()) {
                        field.setError("Campo Obrigatorio");
                    }
                }
            }
        });
    }
}