package com.bitlabs.newslatter

import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
}
