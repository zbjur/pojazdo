package com.pojazdo.architecture.ui.summary.list.holder.childerholder

import android.view.View
import android.widget.RatingBar
import android.widget.TextView
import com.pojazdo.architecture.R
import com.pojazdo.architecture.ui.summary.model.modelsubsection.VehicleRatingSubSection
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder

class VehicleRatingHolder(itemView: View?) : ChildViewHolder(itemView) {

    private var vehicleRatingTypeText: TextView? = null
    private var vehicleRatingBar: RatingBar? = null
    private var vehicleRatingPoints: TextView? = null

    init {
        vehicleRatingTypeText = itemView?.findViewById(R.id.vehicle_rating_type_text)
        vehicleRatingBar = itemView?.findViewById(R.id.vehicle_rating_bar)
        vehicleRatingPoints = itemView?.findViewById(R.id.vehicle_rating_points)
    }

    fun setRating(rating: VehicleRatingSubSection) {
        vehicleRatingTypeText?.text = rating.title
        vehicleRatingBar?.rating = rating.rating.toFloat()
        vehicleRatingPoints?.text = rating.rating
    }
}