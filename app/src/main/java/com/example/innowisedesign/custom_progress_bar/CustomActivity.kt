package com.example.innowisedesign.custom_progress_bar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.example.innowisedesign.R
import java.util.*

class CustomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom)

        val customProgressBar = findViewById<CustomProgressBar>(R.id.customProgressBar)
        val animateBt = findViewById<AppCompatButton>(R.id.animateBarBt)
        animateBt.setOnClickListener {
            val randomValue = Random().nextInt(361)
            customProgressBar.setProgress(randomValue)
        }
    }
}