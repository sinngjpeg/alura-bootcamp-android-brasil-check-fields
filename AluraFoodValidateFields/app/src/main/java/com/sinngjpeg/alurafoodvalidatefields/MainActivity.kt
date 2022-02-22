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

//        initializerFields()

        txtFullName = findViewById(R.id.edt_full_name)
        txtFullNameLayout = findViewById(R.id.edt_full_name_layout)
        fullNameFocusListener()
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
