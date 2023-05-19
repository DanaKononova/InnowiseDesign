package com.example.innowisedesign.profile_layout

data class Profile(
    val name: String,
    val lastName: String,
    val likes: String,
    val comments: String,
    val description: String,
    val recommendations: String,
    val views: String,
    val lastActivity: String,
    val color: Int
): java.io.Serializable
