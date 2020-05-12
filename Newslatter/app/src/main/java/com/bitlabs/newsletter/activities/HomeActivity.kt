package com.bitlabs.newsletter.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bitlabs.newsletter.CreateNewsActivity
import com.bitlabs.newsletter.MainActivity
import com.bitlabs.newsletter.R
import com.bitlabs.newsletter.adapter.PostAdapter
import com.bitlabs.newsletter.model.Post

class HomeActivity : AppCompatActivity() {

    private val listPost = ArrayList<Post>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initData()
        iniRecyclerView()
    }

    fun initData() {
        listPost.add(Post("Android 10", "Android meluncurkan 0S terbaru", "20 Jun 2019"))
        listPost.add(Post("Kebocoran Gas", "Kebocoran gas di lampung", "10 May 2019"))
    }

    fun iniRecyclerView() {
        val rView = findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = PostAdapter(listPost, this)
        rView.layoutManager = LinearLayoutManager(this)
        rView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        rView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_create -> {
                val intent = Intent(this@HomeActivity, CreateNewsActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.menu_profile -> {
                val intent = Intent(this@HomeActivity, ProfileActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.menu_logout -> {
                val intent = Intent(this@HomeActivity, MainActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
