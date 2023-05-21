package com.example.innowisedesign.custom_progress_bar

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.example.innowisedesign.R

class CustomProgressBar(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private val progressPaint: Paint = Paint()
    private val paint: Paint = Paint()
    private var progress: Int = 0

    init {
        progressPaint.color = ContextCompat.getColor(context, R.color.progress_bar_color)
        progressPaint.strokeWidth = 10f
        progressPaint.style = Paint.Style.STROKE
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 40f
        paint.color = ContextCompat.getColor(context, R.color.progress_bar_color)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val centerX = width / 2f
        val centerY = height / 2f
        val radius = (Math.min(width, height) - paint.strokeWidth * 2) / 2f

        canvas.drawCircle(centerX, centerY, radius, progressPaint)

        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 40f
        paint.color = ContextCompat.getColor(context, R.color.progress_bar_color)
        val startAngle = -90f
        val sweepAngle = 1f * progress
        canvas.drawArc(centerX - radius, centerY - radius, centerX + radius, centerY + radius,
            startAngle, sweepAngle, false, paint)

        paint.textSize = 60f
        paint.strokeWidth = 20f
        paint.style = Paint.Style.FILL
        paint.color = ContextCompat.getColor(context, R.color.black)

        val text = progress.toString()
        val textWidth = paint.measureText(text)
        val textHeight = paint.fontMetrics.descent - paint.fontMetrics.ascent

        val textX = centerX - textWidth / 2
        val textY = centerY + textHeight / 2

        canvas.drawText(text, textX, textY, paint)
    }

    fun setProgress(value: Int) {
        progress = value
        invalidate()
    }
}
