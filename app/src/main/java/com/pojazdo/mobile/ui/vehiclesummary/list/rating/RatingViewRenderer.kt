package com.pojazdo.mobile.ui.vehiclesummary.list.rating

import android.view.ViewGroup

import com.github.vivchar.rendererrecyclerviewadapter.ViewRenderer
import com.pojazdo.mobile.R

class RatingViewRenderer : ViewRenderer<VehicleOverallRatingSection, VehicleOverallRatingHolder>(VehicleOverallRatingSection::class.java) {

    override fun bindView(vehicleOverallRatingSection: VehicleOverallRatingSection, vehicleOverallRatingHolder: VehicleOverallRatingHolder) {
        vehicleOverallRatingHolder.setOverallRating(vehicleOverallRatingSection)
    }

    override fun createViewHolder(parent: ViewGroup?): VehicleOverallRatingHolder {
        return VehicleOverallRatingHolder(inflate(R.layout.vehicle_overall_rating, parent))
    }

    interface Listener {
        fun onCategoryClicked(model: UserComments)
    }
}