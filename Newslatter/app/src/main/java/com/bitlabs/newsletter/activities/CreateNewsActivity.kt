package com.bitlabs.newsletter.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bitlabs.newsletter.R
import com.bitlabs.newsletter.helper.NewsletterDBHelper
import com.bitlabs.newsletter.model.Post
import kotlinx.android.synthetic.main.activity_create_news.*

class CreateNewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_news)
    }

    fun insertNews() {
        val db = NewsletterDBHelper(this)
        val news = Post(
            input_title.text.toString(),
            input_body.text.toString(),
            input_date.text.toString()
        )
        db.insertNews(news)
    }
}
