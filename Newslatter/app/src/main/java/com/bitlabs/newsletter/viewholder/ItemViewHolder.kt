package com.bitlabs.newsletter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val title = itemView.title
    val body = itemView.body
    val date = itemView.date
    val btnUpdate = itemView.btn_update
}