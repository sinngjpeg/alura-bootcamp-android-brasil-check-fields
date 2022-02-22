package com.sinngjpeg.alurafoodvalidatefields

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    lateinit var txtFullName: TextInputEditText
    lateinit var txtFullNameLayout: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializerFields()
    }

    private fun initializerFields() {
        configureFullName()
        configureCPF()
        configurePhoneNumber()
        configureEmail()
        configurePassword()
    }

    fun configurePassword() {
        TODO("Not yet implemented")
    }

    fun configureEmail() {
        TODO("Not yet implemented")
    }

    fun configurePhoneNumber() {
        TODO("Not yet implemented")
    }

    fun configureCPF() {
        TODO("Not yet implemented")
    }

    fun configureFullName() {
        txtFullName = findViewById(R.id.edt_full_name)
        txtFullNameLayout = findViewById(R.id.edt_full_name_layout)
    }
}
