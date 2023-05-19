package com.example.innowisedesign.profile_layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.innowisedesign.R
import java.util.*

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        val recycler = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = ProfilesAdapter()
        recycler.adapter = adapter
        recycler.layoutManager = GridLayoutManager(this, 2)

        val profiles = createProfiles()
        adapter.setProfiles(profiles)
    }

    fun createProfiles(): List<Profile> {
        val profiles = mutableListOf<Profile>()

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

            val profile = Profile(name, lastName, likes, comments, occupation, recommendation, views, lastActivity, color)
            profiles.add(profile)
        }

        for (profile in profiles) {
            println(profile)
        }
        return profiles
    }
}