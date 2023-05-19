package com.example.innowisedesign.profile_layout

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.innowisedesign.R

class ProfilesAdapter : RecyclerView.Adapter<ProfileViewHolder>() {

    private val profiles = mutableListOf<Profile>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_profiles, parent, false)
        return ProfileViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.onBind(profiles[position])
    }

    override fun getItemCount(): Int = profiles.size

    @SuppressLint("NotifyDataSetChanged")
    fun setProfiles(list: List<Profile>) {
        profiles.clear()
        profiles.addAll(list)
        notifyDataSetChanged()
    }
}