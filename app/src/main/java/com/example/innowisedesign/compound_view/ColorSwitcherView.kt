package com.example.innowisedesign.compound_view

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.example.innowisedesign.R

class ColorSwitcherView(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    private val colors = arrayOf(
        Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.CYAN,
        Color.MAGENTA, Color.GRAY, Color.DKGRAY, Color.LTGRAY, Color.BLACK
    )

    private val colorTextView: TextView
    private val nextButton: Button
    private val previousButton: Button
    private val colorView: View

    private var currentColorIndex = 0

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.color_switcher_layout, this, true)

        colorTextView = findViewById(R.id.colorTextView)
        nextButton = findViewById(R.id.nextButton)
        previousButton = findViewById(R.id.previousButton)
        colorView = findViewById(R.id.colorView)

        setColorText()
        setButtonListeners()
    }

    private fun setColorText() {
        colorView.setBackgroundColor(colors[currentColorIndex])
        colorTextView.text = currentColorIndex.toString()
    }

    private fun setButtonListeners() {
        nextButton.setOnClickListener {
            currentColorIndex = (currentColorIndex + 1) % colors.size
            setColorText()
        }

        previousButton.setOnClickListener {
            currentColorIndex = if (currentColorIndex > 0) currentColorIndex - 1 else colors.size - 1
            setColorText()
        }
    }
}
