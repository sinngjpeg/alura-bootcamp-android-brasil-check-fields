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
        addValidateField(textInputFullName);

        TextInputLayout textInputCpf = findViewById(R.id.edt_cpf);
        addValidateField(textInputCpf);

        TextInputLayout textInputPhone = findViewById(R.id.edt_phone);
        addValidateField(textInputPhone);

        TextInputLayout textInputEmail = findViewById(R.id.edt_email);
        addValidateField(textInputEmail);

        TextInputLayout textInputPassword = findViewById(R.id.edt_password);
        addValidateField(textInputPassword);

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
}