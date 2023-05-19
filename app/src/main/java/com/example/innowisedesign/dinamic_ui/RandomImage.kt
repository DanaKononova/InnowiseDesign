package com.example.innowisedesign.dinamic_ui

object RandomImage {
    fun generateRandomImageUrl(): String {
        val imageUrls = listOf(
            "https://klike.net/uploads/posts/2019-05/1556867965_1.jpg",
            "https://klike.net/uploads/posts/2019-05/medium/1556867941_3.jpg",
            "https://klike.net/uploads/posts/2019-05/medium/1556867933_4.jpg",
            "https://klike.net/uploads/posts/2019-05/medium/1556867925_6.jpg",
            "https://klike.net/uploads/posts/2019-05/medium/1556868001_8.jpg",
            "https://klike.net/uploads/posts/2019-05/1556867914_10.jpg",
            "https://klike.net/uploads/posts/2019-05/medium/1556867917_11.jpg",
            "https://klike.net/uploads/posts/2019-05/medium/1556867990_12.jpg",
            "https://klike.net/uploads/posts/2019-05/medium/1556867955_13.jpg",
            "https://klike.net/uploads/posts/2019-05/1556867988_14.jpg",
            "https://klike.net/uploads/posts/2019-05/medium/1556868026_15.jpg",
            "https://klike.net/uploads/posts/2019-05/1556867973_17.jpg",
            "https://klike.net/uploads/posts/2019-05/medium/1556867975_19.jpg",
            "https://klike.net/uploads/posts/2019-05/1556867940_20.jpg",
            "https://klike.net/uploads/posts/2019-05/medium/1556867961_22.jpg",
            "https://klike.net/uploads/posts/2019-05/medium/1556867991_23.jpg",
            "https://klike.net/uploads/posts/2019-05/1556868021_24.jpg"
        )
        val randomIndex = (imageUrls.indices).random()

        return imageUrls[randomIndex]
    }
}