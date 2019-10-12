package com.pojazdo.mobile.ui.vehiclesummary.list.vehiclesummary

import android.view.ViewGroup

import com.github.vivchar.rendererrecyclerviewadapter.ViewRenderer
import com.pojazdo.mobile.R

class VehicleSummaryViewRenderer : ViewRenderer<VehicleSummaryInfoModel, VehicleSummaryInfoHolder>(VehicleSummaryInfoModel::class.java) {

    override fun bindView(vehicleSummaryInfoModel: VehicleSummaryInfoModel, vehicleModelHolder: VehicleSummaryInfoHolder) {
        vehicleModelHolder.setVehicleSummaryInfo(vehicleSummaryInfoModel)
    }

    override fun createViewHolder(parent: ViewGroup?): VehicleSummaryInfoHolder {
        return VehicleSummaryInfoHolder(inflate(R.layout.vehicle_details_item, parent))
    }

    interface Listener {
        fun onCategoryClicked(model: VehicleSummaryInfoModel)
    }
}