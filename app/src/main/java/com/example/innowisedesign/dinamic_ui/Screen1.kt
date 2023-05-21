package com.example.innowisedesign.dinamic_ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.innowisedesign.R
import com.squareup.picasso.Picasso

class Screen1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen1)

        val hideButton = findViewById<Button>(R.id.hideButton)
        val showButton = findViewById<Button>(R.id.showButton)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val hiddenText = findViewById<TextView>(R.id.hiddenText)

        val imageUrl = RandomImage.generateRandomImageUrl()

        Picasso.get().load(imageUrl).into(imageView)

        hideButton.setOnClickListener {
            imageView.visibility = View.INVISIBLE
            hiddenText.visibility = View.VISIBLE
        }

        showButton.setOnClickListener {
            imageView.visibility = View.VISIBLE
            hiddenText.visibility = View.INVISIBLE
        }
    }
}