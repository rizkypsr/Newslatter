package com.bitlabs.newsletter.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bitlabs.newsletter.R
import com.bitlabs.newsletter.helper.NewsletterDBHelper
import com.bitlabs.newsletter.model.News
import kotlinx.android.synthetic.main.activity_create_news.*

class CreateNewsActivity : AppCompatActivity() {

    private val db = NewsletterDBHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_news)

        if (intent.getIntExtra("id-extra", 0) == 0) {
            btn_insert.setOnClickListener {
                insertNews()
                Toast.makeText(this, "Success Insert Data", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@CreateNewsActivity, HomeActivity::class.java)
                startActivity(intent)
            }
        } else {
            title_create.text = "Update Title"
            input_title.setText(intent.getStringExtra("title-extra"))
            input_body.setText(intent.getStringExtra("body-extra"))
            input_date.setText(intent.getStringExtra("date-extra"))
            btn_insert.setOnClickListener {
                updateNews()
                Toast.makeText(this, "Success Update Data", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@CreateNewsActivity, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun insertNews() {
        val news = News(
            input_title.text.toString(),
            input_body.text.toString(),
            input_date.text.toString()
        )
        db.insertNews(news)
    }

    private fun updateNews() {
        val id = intent.getIntExtra("id-extra", 0)
        val news = News(
            input_title.text.toString(),
            input_body.text.toString(),
            input_date.text.toString()
        )
        db.updateNews(news, id)
    }
}