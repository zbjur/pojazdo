package com.pojazdo.mobile.ui.vehiclesummary.view

import android.content.Context
import android.graphics.PorterDuff
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.pojazdo.mobile.R
import kotlinx.android.synthetic.main.timeline_bar_view_start.view.*

class PojazdoTimeLineVerticalBarView(context: Context?, attrs: AttributeSet?) : ConstraintLayout(context, attrs) {

    init {
        View.inflate(context, R.layout.timeline_bar_view_start, this)
        context?.obtainStyledAttributes(attrs, R.styleable.PojazdoTimeLineVerticalBarView, 0, 0)?.let {
            lineBar.layoutParams.apply {
                width = it.getDimensionPixelSize(R.styleable.PojazdoTimeLineVerticalBarView_diameter, 14)
            }
            it.recycle()
        }

        val color = R.color.green
        val mode = PorterDuff.Mode.DARKEN
        circleBar.background.setColorFilter(resources.getColor(R.color.green),mode)
    }
}