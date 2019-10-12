package com.pojazdo.mobile.ui.vehiclesummary.list.map

import android.view.ViewGroup

import com.github.vivchar.rendererrecyclerviewadapter.ViewRenderer
import com.pojazdo.mobile.R

class MapViewRenderer : ViewRenderer<VehicleMapSection, VehicleMapHolder>(VehicleMapSection::class.java) {

    override fun bindView(VehiclePersonalDataSection: VehicleMapSection, vehicleModelHolder: VehicleMapHolder) {
        vehicleModelHolder.setLocation(VehiclePersonalDataSection)
    }

    override fun createViewHolder(parent: ViewGroup?): VehicleMapHolder {
        return VehicleMapHolder(inflate(R.layout.vehicle_map_item, parent))
    }

    interface Listener {
        fun onCategoryClicked(model: VehicleMapSection)
    }
}