package com.example.innowisedesign.dinamic_ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.example.innowisedesign.R

class StartScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_screen)

        findViewById<AppCompatButton>(R.id.screen1_bt).setOnClickListener {
            val intent = Intent(this, Screen1::class.java)
            startActivity(intent)
        }

        findViewById<AppCompatButton>(R.id.screen2_bt).setOnClickListener {
            val intent = Intent(this, Screen2::class.java)
            startActivity(intent)
        }

        findViewById<AppCompatButton>(R.id.screen3_bt).setOnClickListener {
            val intent = Intent(this, Screen3::class.java)
            startActivity(intent)
        }
    }
}