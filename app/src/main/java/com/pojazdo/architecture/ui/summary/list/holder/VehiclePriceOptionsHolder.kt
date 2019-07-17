package com.pojazdo.architecture.ui.summary.list.holder

import android.view.View
import android.widget.TextView
import com.pojazdo.architecture.R
import com.pojazdo.architecture.ui.summary.model.VehiclePriceSection
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder

class VehiclePriceOptionsHolder(itemView: View?) : ChildViewHolder(itemView) {

    private var minVehiclePrice: TextView? = null
    private var maxVehiclePrice: TextView? = null
    private var avgVehiclePrice: TextView? = null

    init {
        minVehiclePrice = itemView?.findViewById(R.id.min_vehicle_price)
        maxVehiclePrice = itemView?.findViewById(R.id.max_vehicle_price)
        avgVehiclePrice = itemView?.findViewById(R.id.avg_vehicle_price)
    }

    fun setPrices(price: VehiclePriceSection) {
        this.minVehiclePrice?.text = price.minPrice
        this.maxVehiclePrice?.text = price.maxPrice
        this.avgVehiclePrice?.text = price.avgPrice
    }
}