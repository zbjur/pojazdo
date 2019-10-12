package com.pojazdo.mobile.ui.vehiclesummary.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.pojazdo.mobile.R
import kotlinx.android.synthetic.main.timeline_circle_view.view.*

class PojazdoTimeLineCircleView(context: Context?, attrs: AttributeSet?) : ConstraintLayout(context, attrs), PojazdoTimeLineCircleViewContract.View {

    init {
        View.inflate(context, R.layout.timeline_circle_view, this)
        layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        setTimeLineCircleBackground(R.drawable.time_line_img_shape)
    }

    override fun setTimeLineCircleBackground(timeLineIconIndicatorDrawable: Int) {
        timeline_circle_img_holder.setImageResource(timeLineIconIndicatorDrawable)
    }
}