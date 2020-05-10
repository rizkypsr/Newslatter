package com.bitlabs.newsletter

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val PRIVATE_MODE = 0
    private val PREF_NAME = "bitlabs"
    private var sharedPref: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPref = this.getSharedPreferences(PREF_NAME, PRIVATE_MODE)

        btn_submit.setOnClickListener {
            validateForm()
        }
    }

    private fun validateForm() {
        if (validateName() && validateEmail() && validatePassword() && validateGender()) {
            Toast.makeText(this@MainActivity, "Success", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, HomeActivity::class.java)
            val editor = sharedPref?.edit()

            editor?.putString("user-name", edit_name.text.toString())
            editor?.putString("user-email", edit_email.text.toString())
            editor?.apply()
            startActivity(intent)
        }
    }

    private fun validateName(): Boolean {
        if (edit_name.text.isEmpty()) {
            error_name.text = "Name must be filled"
            return false
        } else {
            error_name.text = null
            return true
        }
    }

    private fun validateEmail(): Boolean {
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

    private fun validatePassword(): Boolean {
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

    private fun validateGender(): Boolean {
        if (radio_group.checkedRadioButtonId == -1) {
            error_gender.text = "Gender must be selected"
            return false
        } else {
            error_gender.text = null
            return true
        }
    }
}
