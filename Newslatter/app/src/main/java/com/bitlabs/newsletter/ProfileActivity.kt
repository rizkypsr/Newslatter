package com.bitlabs.newsletter

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    private val PRIVATE_MODE = 0
    private val PREF_NAME = "bitlabs"
    private var sharedPref: SharedPreferences? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        sharedPref = this.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        user_profile_name.text = sharedPref?.getString("user-name", "")
        user_profile_email.text = sharedPref?.getString("user-email", "")
    }
}
