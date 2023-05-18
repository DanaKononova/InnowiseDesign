package com.example.innowisedesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val text1 = findViewById<TextView>(R.id.content1)
        val text2 = findViewById<TextView>(R.id.content2)

        text1.text = getString(R.string.content1)
        text2.text = getString(R.string.content2)

        val scrollView = findViewById<ScrollView>(R.id.scrollView)
        val button = findViewById<AppCompatButton>(R.id.button2)

        scrollView.post {
            val diff = scrollView.getChildAt(0).height - (scrollView.height + scrollView.scrollY)
            button.visibility = if (diff <= 0) View.VISIBLE else View.GONE
        }

        scrollView.viewTreeObserver.addOnScrollChangedListener {
            val diff = scrollView.getChildAt(0).height - (scrollView.height + scrollView.scrollY)
            button.visibility = if (diff <= 0) View.VISIBLE else View.GONE
        }
    }
}