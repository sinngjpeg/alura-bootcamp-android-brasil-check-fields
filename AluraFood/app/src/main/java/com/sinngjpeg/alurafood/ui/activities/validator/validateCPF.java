package com.sinngjpeg.alurafood.ui.activities.validator;

import android.widget.EditText;

import androidx.annotation.NonNull;

import com.google.android.material.textfield.TextInputLayout;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;

public class validateCPF {

    private final TextInputLayout textInputCpf;
    private final EditText cpfField;

    public validateCPF(TextInputLayout textInputCpf) {
        this.textInputCpf = textInputCpf;
        this.cpfField = textInputCpf.getEditText();
    }


    private boolean validateCalculationCPF() {
        String cpf = getCpf();
        try {
            CPFValidator cpfValidator = new CPFValidator();
            cpfValidator.assertValid(cpf);
        } catch (InvalidStateException e) {
            textInputCpf.setError("CPF inválido");
            return false;
        }
        return true;
    }

    public boolean isValidCpf() {
        if (!validateFieldWith11Digits()) return false;
        if (!validateCalculationCPF()) return false;
        return true;
    }


    private boolean validateFieldWith11Digits() {
        String cpf = getCpf();
        if (cpf.length() != 11) {
            textInputCpf.setError("O CPF precisa ter 11 digitos");
            return false;
        }
        return true;
    }

    @NonNull
    private String getCpf() {
        return cpfField.getText().toString();
    }


}
