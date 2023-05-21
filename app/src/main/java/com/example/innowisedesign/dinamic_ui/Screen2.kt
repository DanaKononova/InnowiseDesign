package com.example.innowisedesign.dinamic_ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.innowisedesign.R

class Screen2 : AppCompatActivity() {
    private val imageUrls = mutableListOf<String>()
    private lateinit var imageAdapter: ImageAdapter
    private lateinit var imageRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen2)

        imageRecyclerView = findViewById(R.id.imageRecyclerView)
        imageAdapter = ImageAdapter(imageUrls)
        imageRecyclerView.adapter = imageAdapter
        imageRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)

        val addButton = findViewById<Button>(R.id.add_button)
        val removeButton = findViewById<Button>(R.id.remove_button)

        addButton.setOnClickListener { addRandomImage() }
        removeButton.setOnClickListener { removeLastImage() }
    }

    private fun addRandomImage() {
        val randomImageUrl = RandomImage.generateRandomImageUrl()
        imageUrls.add(randomImageUrl)
        imageAdapter.notifyItemInserted(imageUrls.size - 1)
        imageRecyclerView.scrollToPosition(imageUrls.size - 1)
    }

    private fun removeLastImage() {
        if (imageUrls.isNotEmpty()) {
            imageUrls.removeAt(imageUrls.size - 1)
            imageAdapter.notifyItemRemoved(imageUrls.size)
        }
    }
}