package com.pojazdo.mobile.ui.vehiclesummary.list.holder.childerholder

import android.view.View
import android.widget.TextView
import com.pojazdo.mobile.R
import com.pojazdo.mobile.ui.vehiclesummary.list.avarageprices.VehicleAveragePriceSection
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder

class VehiclePriceOptionsHolder(itemView: View?) : ChildViewHolder(itemView) {

    private var minVehiclePrice: TextView? = null
    private var maxVehiclePrice: TextView? = null
    private var avgVehiclePrice: TextView? = null

    init {
        minVehiclePrice = itemView?.findViewById(R.id.min_vehicle_price)
        maxVehiclePrice = itemView?.findViewById(R.id.max_vehicle_price_text)
        avgVehiclePrice = itemView?.findViewById(R.id.average_vehicle_price_text)
    }

    fun setPrices(averagePrice: VehicleAveragePriceSection) {
        this.minVehiclePrice?.text = averagePrice.minPrice
        this.maxVehiclePrice?.text = averagePrice.maxPrice
        this.avgVehiclePrice?.text = averagePrice.avgPrice
    }
}