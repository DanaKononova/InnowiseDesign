package com.example.innowisedesign.dinamic_ui

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.innowisedesign.R
import com.squareup.picasso.Picasso

class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun onBind(imageUrl: String) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        Picasso.get().load(imageUrl).into(imageView)
    }

}