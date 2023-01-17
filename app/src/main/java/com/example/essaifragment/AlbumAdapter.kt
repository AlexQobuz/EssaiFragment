package com.example.essaifragment

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class AlbumAdapter(val albums: List<Album>, val itemClickListener: OnClickListener)
    : RecyclerView.Adapter<AlbumAdapter.ViewHolder>(){

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val cardView = itemView.findViewById(R.id.card_view) as CardView
            val titleView = cardView.findViewById(R.id.title_album) as TextView
            val descriptionView = cardView.findViewById(R.id.description_album) as TextView
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_album, parent, false)
        return ViewHolder(viewItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val album = albums[position]
        holder.cardView.setOnClickListener(itemClickListener)
        holder.cardView.tag = position
        holder.titleView.text = album.title
        holder.titleView.text = album.descritpion
    }

    override fun getItemCount(): Int {
        return albums.size
    }

}