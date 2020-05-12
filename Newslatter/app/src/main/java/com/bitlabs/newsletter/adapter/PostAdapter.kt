package com.bitlabs.newsletter.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bitlabs.newsletter.R
import com.bitlabs.newsletter.activities.CreateNewsActivity
import com.bitlabs.newsletter.helper.NewsletterDBHelper
import com.bitlabs.newsletter.model.News
import com.bitlabs.newsletter.viewholder.ItemViewHolder

class PostAdapter(val items: ArrayList<News>, val context: Context) :
    RecyclerView.Adapter<ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.title.text = items[position].title
        holder.body.text = items[position].body
        holder.date.text = items[position].date
        holder.btnUpdate.setOnClickListener {
            val intent = Intent(context, CreateNewsActivity::class.java)
            intent.putExtra("id-extra", items[position].id)
            intent.putExtra("title-extra", items[position].title)
            intent.putExtra("body-extra", items[position].body)
            intent.putExtra("date-extra", items[position].date)
            context.startActivity(intent)
        }
        holder.btnDelete.setOnClickListener {
            val db = NewsletterDBHelper(context)
            db.deleteNews(items[position].id)
            (context as Activity).finish()
            context.startActivity(context.intent)
            Toast.makeText(context, "Success Delete Data", Toast.LENGTH_SHORT).show()
        }
    }
}