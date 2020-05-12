package com.bitlabs.newsletter.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bitlabs.newsletter.R
import com.bitlabs.newsletter.activities.CreateNewsActivity
import com.bitlabs.newsletter.model.Post
import com.bitlabs.newsletter.viewholder.ItemViewHolder

class PostAdapter(val items: ArrayList<Post>, val context: Context) :
    RecyclerView.Adapter<ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.title.text = items[position].title
        holder.body.text = items[position].detail
        holder.date.text = items[position].date
        holder.btnUpdate.setOnClickListener {
            val intent = Intent(context, CreateNewsActivity::class.java)
            intent.putExtra("id_extra", items.get(position).id)
            intent.putExtra("title_extra", items.get(position).title)
            intent.putExtra("body_extra", items.get(position).detail)
            intent.putExtra("date_extra", items.get(position).date)
            context.startActivity(intent)
        }
    }
}