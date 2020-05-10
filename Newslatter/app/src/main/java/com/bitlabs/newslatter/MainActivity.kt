package com.bitlabs.newslatter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun validateName(): Boolean {
        if (edit_name.text.length == 0) {
            error_name.text = "Name must be filled"
            return false
        } else {
            error_name.text = null
            return true
        }
    }
}
