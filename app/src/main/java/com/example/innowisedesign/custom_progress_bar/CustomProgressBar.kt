package com.example.innowisedesign.custom_progress_bar

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.Button
import com.example.innowisedesign.R

class CustomProgressBar(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private val maxProgress = 100
    private var currentProgress = 0
    private val progressPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val button: Button

    init {
        progressPaint.color = Color.BLUE
        button = Button(context)
        button.text = "increase Progress"
        button.setOnClickListener {
            animateProgress()
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val width = width.toFloat()
        val height = height.toFloat()
        val progressWidth = (currentProgress / maxProgress.toFloat()) * width
        canvas.drawRect(0f, 0f, progressWidth, height, progressPaint)
    }

    private fun animateProgress() {
        val animator = ObjectAnimator.ofInt(this, "currentProgress", currentProgress, (0..maxProgress).random())
        animator.duration = 1000
        animator.interpolator = DecelerateInterpolator()
        animator.start()
    }

    fun setCurrentProgress(progress: Int) {
        currentProgress = progress
        invalidate()
    }
}
