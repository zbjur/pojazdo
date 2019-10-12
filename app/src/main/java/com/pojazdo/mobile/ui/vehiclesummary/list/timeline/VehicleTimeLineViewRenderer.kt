package com.pojazdo.mobile.ui.vehiclesummary.list.timeline

import android.view.ViewGroup

import com.github.vivchar.rendererrecyclerviewadapter.ViewRenderer
import com.pojazdo.mobile.R

class VehicleTimeLineViewRenderer : ViewRenderer<VehicleTimeLine, VehicleTimeLineHolder>(VehicleTimeLine::class.java) {

    override fun bindView(VehicleTimeLine: VehicleTimeLine, vehicleModelHolder: VehicleTimeLineHolder) {
        vehicleModelHolder.setTimeLine(VehicleTimeLine)
    }

    override fun createViewHolder(parent: ViewGroup?): VehicleTimeLineHolder {
        return VehicleTimeLineHolder(inflate(R.layout.vehicle_timeline_item, parent))
    }

    interface Listener {
        fun onCategoryClicked(model: VehicleTimeLine)
    }
}