package com.example.innowisedesign.profile_layout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.innowisedesign.R
import java.util.*
import kotlin.collections.ArrayList

class MainActivity5 : AppCompatActivity() {

    private var handler = Looper.myLooper()?.let { Handler(it) }
    private var profiles = mutableListOf<Profile>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        val itemClick: (profile: Profile) -> Unit = { profile ->
            val intent = Intent(this@MainActivity5, ProfileActivity::class.java)
            intent.putExtra("profile", profile)
            startActivity(intent)
        }

        val recycler = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = ProfilesAdapter(itemClick)
        recycler.adapter = adapter
        recycler.layoutManager = GridLayoutManager(this, 2)

        profiles = createProfiles()
        adapter.setProfiles(profiles)

        handler?.postDelayed(updateProfileRunnable(), 5000)
    }

    fun createProfiles(): MutableList<Profile> {
        val profilesExample = mutableListOf<Profile>()

        val names = listOf("Dana", "John", "Emily", "Michael", "Sara", "David", "Olivia", "Daniel", "Sophia", "Matthew")
        val lastNames = listOf("Smith", "Johnson", "Brown", "Taylor", "Anderson", "Williams", "Jones", "Davis", "Wilson", "Clark")
        val maxLikes = 1000
        val maxComments = 1000
        val occupations = listOf(
            "Model winner of 2018 Tokyo Art costume design week",
            "Digital Marketing Specialist at a leading tech company",
            "Founder and CEO of a fashion startup",
            "Art Director at a renowned advertising agency",
            "Creative Writer for a popular lifestyle magazine",
            "Professional Photographer specializing in fashion and beauty",
            "Fashion Stylist for celebrity clients",
            "Curator at a contemporary art gallery",
            "Fashion Blogger with a large online following",
            "Product Designer at a cutting-edge technology company")
        val recommendations = listOf("1 / 10 users", "2 / 10 users", "3 / 10 users", "4 / 10 users", "5 / 10 users", "6 / 10 users", "7 / 10 users", "8 / 10 users", "9 / 10 users", "10 / 10 users")
        val maxViews = 1000
        val timeAgo = listOf("minute ago", "hour ago", "day ago", "week ago", "5 minutes ago", "recent", "active", "long time ago")

        val random = Random()

        var id = 1
        repeat(10) {
            val name = names[random.nextInt(names.size)]
            val lastName = lastNames[random.nextInt(lastNames.size)]
            val likes = random.nextInt(maxLikes).toString()
            val comments = random.nextInt(maxComments).toString()
            val occupation = occupations[random.nextInt(occupations.size)]
            val recommendation = recommendations[random.nextInt(recommendations.size)]
            val views = random.nextInt(maxViews).toString()
            val lastActivity = timeAgo[random.nextInt(timeAgo.size)]
            val color = random.nextInt(10) + 1

            val profile = Profile(id++, name, lastName, likes, comments, occupation, recommendation, views, lastActivity, color)
            profilesExample.add(profile)
        }
        return profilesExample
    }

    fun updateProfiles(){
        val maxLikes = 1000
        val maxComments = 1000
        val recommendations = listOf("1 / 10 users", "2 / 10 users", "3 / 10 users", "4 / 10 users", "5 / 10 users", "6 / 10 users", "7 / 10 users", "8 / 10 users", "9 / 10 users", "10 / 10 users")
        val maxViews = 1000
        val timeAgo = listOf("minute ago", "hour ago", "day ago", "week ago", "5 minutes ago", "recent", "active", "long time ago")

        val random = Random()

        for (profile in profiles) {
            profile.likes = random.nextInt(maxLikes).toString()
            profile.comments = random.nextInt(maxComments).toString()
            profile.recommendations = recommendations[random.nextInt(recommendations.size)]
            profile.views = random.nextInt(maxViews).toString()
            profile.lastActivity = timeAgo[random.nextInt(timeAgo.size)]
        }
    }

    private fun updateProfileRunnable(): Runnable {
        return object : Runnable {
            override fun run() {
                updateProfiles()
                handler?.postDelayed(this, 5000)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        handler?.removeCallbacks(updateProfileRunnable())
    }
}