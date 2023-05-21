package com.example.innowisedesign.dinamic_ui

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.innowisedesign.R

class Screen3 : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private var alphaValue = 1.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen3)

        imageView = findViewById(R.id.transparentImage)
        loadImage()

        val addAlphaButton = findViewById<Button>(R.id.addAlphaBt)
        addAlphaButton.setOnClickListener { addAlpha() }

        val removeAlphaButton = findViewById<Button>(R.id.removeAlphaBt)
        removeAlphaButton.setOnClickListener { removeAlpha() }
    }

    private fun loadImage() {
        val randomImageUrl = RandomImage.generateRandomImageUrl()
        Glide
            .with(this)
            .load(randomImageUrl)
            .into(imageView)
    }

    private fun addAlpha() {
        alphaValue -= 0.1f
        animateAlpha(alphaValue)
    }

    private fun removeAlpha() {
        alphaValue += 0.1f
        animateAlpha(alphaValue)
    }

    private fun animateAlpha(alpha: Float) {
        val animator = ObjectAnimator.ofFloat(imageView, View.ALPHA, alpha)
        animator.duration = 500
        animator.start()
    }
}