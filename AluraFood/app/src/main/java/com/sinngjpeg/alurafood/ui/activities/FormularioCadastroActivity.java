package com.sinngjpeg.alurafood.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;
import com.sinngjpeg.alurafood.R;

public class FormularioCadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_cadastro);

        TextInputLayout textInputFullName = findViewById(R.id.edt_full_name);
        EditText fieldFullName = textInputFullName.getEditText();
        String fullName = fieldFullName.getText().toString();
        if(fullName.isEmpty()){
            fieldFullName.setError("Campo Obrigatorio");
        }
    }
}