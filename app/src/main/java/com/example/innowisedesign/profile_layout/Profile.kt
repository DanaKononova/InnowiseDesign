package com.example.innowisedesign.profile_layout

data class Profile(
    val id: Int,
    val name: String,
    val lastName: String,
    var likes: String,
    var comments: String,
    val description: String,
    var recommendations: String,
    var views: String,
    var lastActivity: String,
    val color: Int
): java.io.Serializable
