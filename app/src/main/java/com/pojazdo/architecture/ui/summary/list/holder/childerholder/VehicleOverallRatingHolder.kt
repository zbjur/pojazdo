package com.pojazdo.architecture.ui.summary.list.holder.childerholder

import android.view.View
import android.widget.TextView
import com.pojazdo.architecture.R
import com.pojazdo.architecture.ui.summary.model.modelsubsection.VehicleOverallRatingSubSection
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder

class VehicleOverallRatingHolder(itemView: View?) : ChildViewHolder(itemView) {

    private var averageVehicleRating: TextView? = null
    private var overallVehicleTitle: TextView? = null
    private var buyAgainPercentage: TextView? = null
    private var buyAgainTitle: TextView? = null

    init {
        averageVehicleRating = itemView?.findViewById(R.id.average_vehicle_rating)
        overallVehicleTitle = itemView?.findViewById(R.id.overall_vehicle_title)
        buyAgainPercentage = itemView?.findViewById(R.id.buy_again_percentage)
        buyAgainTitle = itemView?.findViewById(R.id.buy_again_title)
    }

    fun setOverallRating(rating: VehicleOverallRatingSubSection) {
        averageVehicleRating?.text = rating.overallRating
        overallVehicleTitle?.text = rating.overallTitle
        buyAgainPercentage?.text = rating.buyAgainPercentage
        buyAgainTitle?.text = rating.buyAgainTitle
    }
}