package com.pojazdo.architecture.ui.summary.list.holder

import android.view.View
import android.widget.TextView
import com.pojazdo.architecture.R
import com.pojazdo.architecture.ui.summary.model.VehicleRatingSection
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder

class VehicleRatingHolder(itemView: View?) : ChildViewHolder(itemView) {

    private var ratingPoints: TextView? = null
    private var ratingBrand: TextView? = null
    private var ratingModel: TextView? = null
    private var ratingUser: TextView? = null
    private var ratingText: TextView? = null

    init {
        ratingPoints = itemView?.findViewById(R.id.rating_vehicle_points)
        ratingBrand = itemView?.findViewById(R.id.rating_vehicle_brand)
        ratingModel = itemView?.findViewById(R.id.rating_vehicle_points)
        ratingText = itemView?.findViewById(R.id.rating_vehicle_comment)
    }

    fun setRating(rating: VehicleRatingSection) {
        ratingPoints?.text = rating.rating
        ratingBrand?.text = rating.brand
        ratingModel?.text = rating.model
        ratingText?.text = rating.ratingText
    }
}