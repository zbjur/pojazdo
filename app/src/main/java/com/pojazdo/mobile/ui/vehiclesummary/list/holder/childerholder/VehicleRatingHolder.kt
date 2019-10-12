package com.pojazdo.mobile.ui.vehiclesummary.list.holder.childerholder

import android.view.View
import android.widget.TextView
import com.pojazdo.mobile.R
import com.pojazdo.mobile.ui.vehiclesummary.model.modelsubsection.VehicleRatingSubSection
import com.skydoves.progressview.ProgressView
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder

class VehicleRatingHolder(itemView: View?) : ChildViewHolder(itemView) {

    private var vehicleRatingTypeText: TextView? = null
    private var vehicleRatingBar: ProgressView? = null
    private var vehicleRatingPoints: TextView? = null

    init {
        vehicleRatingTypeText = itemView?.findViewById(R.id.vehicle_rating_type_text)
        vehicleRatingBar = itemView?.findViewById(R.id.vehicle_rating_bar)
        vehicleRatingPoints = itemView?.findViewById(R.id.vehicle_rating_points)
    }

    fun setRating(rating: VehicleRatingSubSection) {
        vehicleRatingTypeText?.text = rating.title
        vehicleRatingBar?.progress = rating.rating.toFloat()
        vehicleRatingPoints?.text = rating.rating
    }
}