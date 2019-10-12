package com.pojazdo.mobile.ui.vehiclesummary.rating.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.pojazdo.mobile.R
import kotlinx.android.synthetic.main.vehicle_rating_item.view.*

class PojazdoProgressView(context: Context?, attrs: AttributeSet?) : ConstraintLayout(context, attrs), PojazdoProgressViewContract.View {

    init {
        View.inflate(context, R.layout.custom_vehicle_rating_item, this)
        layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        val attributes = context?.obtainStyledAttributes(attrs, R.styleable.PojazdoProgressView, 0, 0)
        val ratingTitleHeader = attributes?.getString(R.styleable.PojazdoProgressView_ratingHeaderText)
        attributes?.recycle()
        setRatingDescriptionText(ratingTitleHeader)
    }

    private fun setRatingDescriptionText(ratingText: String?) {
        vehicle_rating_type_text?.text = ratingText
    }

    override fun setRatingPointsText(ratingText: String) {
        vehicle_rating_points?.text = ratingText
    }

    override fun setRatingPointsProgressView(ratingValue: Float) {
        vehicle_rating_bar?.progress = ratingValue
    }
}