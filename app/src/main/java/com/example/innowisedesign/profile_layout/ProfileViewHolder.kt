package com.example.innowisedesign.profile_layout

import android.content.Intent
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.innowisedesign.R

class ProfileViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
    fun onBind(profile: Profile) {

        val name = itemView.findViewById<TextView>(R.id.profileName)
        name.text = "${profile.name} ${profile.lastName}"

        itemView.setOnClickListener {
            val intent = Intent(itemView.context, ProfileActivity::class.java)
            intent.putExtra("profile", profile)
            itemView.context.startActivity(intent)
        }
    }
}