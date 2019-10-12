package com.pojazdo.mobile.ui.vehiclesummary.list.rating

import android.view.ViewGroup

import com.github.vivchar.rendererrecyclerviewadapter.ViewRenderer
import com.pojazdo.mobile.R
import com.pojazdo.mobile.ui.vehiclesummary.list.avarageprices.VehicleAveragePriceHolder
import com.pojazdo.mobile.ui.vehiclesummary.list.avarageprices.VehicleAveragePriceSection

class VehicleAveragePriceViewRenderer : ViewRenderer<VehicleAveragePriceSection, VehicleAveragePriceHolder>(VehicleAveragePriceSection::class.java) {

    override fun bindView(VehicleOverallRatingSection: VehicleAveragePriceSection, vehicleModelHolder: VehicleAveragePriceHolder) {
        vehicleModelHolder.setPrices(VehicleOverallRatingSection)
    }

    override fun createViewHolder(parent: ViewGroup?): VehicleAveragePriceHolder {
        return VehicleAveragePriceHolder(inflate(R.layout.vehicle_price_item, parent))
    }

    interface Listener {
        fun onCategoryClicked(model: VehicleAveragePriceSection)
    }
}