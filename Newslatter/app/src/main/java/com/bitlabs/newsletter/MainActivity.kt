package com.bitlabs.newsletter

import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_submit.setOnClickListener {
            validateForm()
        }
    }

    fun validateForm() {
        if (validateName() && validateEmail() && validatePassword() && validateGender()) {
            Toast.makeText(this@MainActivity, "Success", Toast.LENGTH_SHORT).show()
        }
    }

    fun validateName(): Boolean {
        if (edit_name.text.isEmpty()) {
            error_name.text = "Name must be filled"
            return false
        } else {
            error_name.text = null
            return true
        }
    }

    fun validateEmail(): Boolean {
        if (edit_email.text.isEmpty()) {
            error_email.text = "Email must be filled"
            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(edit_email.text).matches()) {
            error_email.text = "Must Match Email Pattern"
            return false
        } else {
            error_email.text = null
            return true
        }
    }

    fun validatePassword(): Boolean {
        if (edit_password.text.isEmpty()) {
            error_password.text = "Password must be filled"
            return false
        } else if (edit_password.text.length < 8) {
            error_password.text = "Password must be 7 characters or longer"
            return false
        } else {
            error_password.text = null
            return true
        }
    }

    fun validateGender(): Boolean {
        if (radio_group.checkedRadioButtonId == -1) {
            error_gender.text = "Gender must be selected"
            return false
        } else {
            error_gender.text = null
            return true
        }
    }


}
