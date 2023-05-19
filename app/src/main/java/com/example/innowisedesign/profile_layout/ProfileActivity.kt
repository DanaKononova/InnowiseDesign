package com.example.innowisedesign.profile_layout

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.example.innowisedesign.R

class ProfileActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        window.statusBarColor = Color.TRANSPARENT
        setContentView(R.layout.activity_profile)

        val profile = intent.getSerializableExtra("profile", Profile::class.java)
        val view = findViewById<View>(R.id.viewId)
        when (profile?.color) {
            1 -> view.background = ContextCompat.getDrawable(this, R.drawable.gradient_color1)
            2 -> view.background = ContextCompat.getDrawable(this, R.drawable.gradient_color2)
            3 -> view.background = ContextCompat.getDrawable(this, R.drawable.gradient_color3)
            4 -> view.background = ContextCompat.getDrawable(this, R.drawable.gradient_color4)
            5 -> view.background = ContextCompat.getDrawable(this, R.drawable.gradient_color5)
            6 -> view.background = ContextCompat.getDrawable(this, R.drawable.gradient_color6)
            7 -> view.background = ContextCompat.getDrawable(this, R.drawable.gradient_color7)
            8 -> view.background = ContextCompat.getDrawable(this, R.drawable.gradient_color8)
            9 -> view.background = ContextCompat.getDrawable(this, R.drawable.gradient_color9)
            10 -> view.background = ContextCompat.getDrawable(this, R.drawable.gradient_color10)
        }

        findViewById<TextView>(R.id.description).text = profile?.description
        findViewById<TextView>(R.id.nickname).text = "${profile?.name} ${profile?.lastName}"
        findViewById<TextView>(R.id.active).text = profile?.lastActivity
        findViewById<TextView>(R.id.recommend_amount).text = profile?.recommendations
        findViewById<TextView>(R.id.comments_tv).text = profile?.comments
        findViewById<TextView>(R.id.likes_tv).text = profile?.likes
        findViewById<TextView>(R.id.views_tv).text = profile?.views

        val backButton = findViewById<ImageButton>(R.id.back_bt)
        backButton.setOnClickListener {
            finish()
        }
    }

}














