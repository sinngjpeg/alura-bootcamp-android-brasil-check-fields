package com.sinngjpeg.alurafoodvalidatefields

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    lateinit var txtFullName: TextInputEditText
    lateinit var txtFullNameLayout: TextInputLayout
    lateinit var txtCPF: TextInputEditText
    lateinit var txtCPFLayout: TextInputLayout
    lateinit var txtPhoneNumber: TextInputEditText
    lateinit var txtPhoneNumberLayout: TextInputLayout
    lateinit var txtEmail: TextInputEditText
    lateinit var txtEmailLayout: TextInputLayout
    lateinit var txtPassword: TextInputEditText
    lateinit var txtPasswordLayout: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializerFields()
    }

    private fun configureFullNameField() {
        txtFullName = findViewById(R.id.edt_full_name)
        txtFullNameLayout = findViewById(R.id.edt_full_name_layout)
        fullNameFocusListener()
    }

    private fun configureCPFField() {
        txtCPF = findViewById(R.id.edt_cpf)
        txtCPFLayout = findViewById(R.id.edt_cpf_layout)
        cpfFocusListener()
    }

    private fun configurePhoneNumberField() {
        txtPhoneNumber = findViewById(R.id.edt_phone)
        txtPhoneNumberLayout = findViewById(R.id.edt_phone_layout)
    }

    private fun configureEmailField() {
        txtEmail = findViewById(R.id.edt_email)
        txtEmailLayout = findViewById(R.id.edt_email_layout)
    }

    private fun configurePasswordField() {
        txtPassword = findViewById(R.id.edt_password)
        txtPasswordLayout = findViewById(R.id.edt_password_layout)
    }

    private fun initializerFields() {
        configureFullNameField()
        configureCPFField()
        configurePhoneNumberField()
        configureEmailField()
        configurePasswordField()
    }

    private fun cpfFocusListener() {
        txtCPF.setOnFocusChangeListener { _, focused ->
            when {
                !focused -> {
                    txtCPFLayout.helperText = validateCPF()
                }
                else -> txtCPFLayout.isHelperTextEnabled = false
            }
        }
    }

    private fun validateCPF(): String? {
        val cpfText = txtCPF.text.toString()
        when {
            cpfText.isEmpty() -> {
                return getString(R.string.cpf_empty)
            }
            cpfText.length != 11 -> {
                return getString(R.string.cpf_length)
            }
            else -> return null
        }
    }

    fun fullNameFocusListener() {
        txtFullName.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                txtFullNameLayout.helperText = validateFullName()
            }
        }
    }

    fun validateFullName(): String? {
        val fullNameText = txtFullName.text.toString()
        if (fullNameText.isEmpty()) {
            return getString(R.string.full_name_empty)
        }
        return null
    }
}
