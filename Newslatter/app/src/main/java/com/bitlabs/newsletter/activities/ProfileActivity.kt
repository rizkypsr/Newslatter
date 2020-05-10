package com.bitlabs.newsletter.activities

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bitlabs.newsletter.R
import com.bumptech.glide.Glide
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

        val image: ImageView = findViewById(R.id.img_profile)
        Glide.with(this)
            .load("https://cdn.pixabay.com/photo/2017/06/13/12/53/profile-2398782_1280.png")
            .into(image)
    }
}
