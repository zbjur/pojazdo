package com.pojazdo.mobile.ui.vehiclesummary.list.sellerdetails

import android.view.ViewGroup

import com.github.vivchar.rendererrecyclerviewadapter.ViewRenderer
import com.pojazdo.mobile.R

class SellerDetailsViewRenderer : ViewRenderer<VehiclePersonalDataSection, VehiclePersonalDataGroupHolder>(VehiclePersonalDataSection::class.java) {

    override fun bindView(VehiclePersonalDataSection: VehiclePersonalDataSection, vehicleModelHolder: VehiclePersonalDataGroupHolder) {
        vehicleModelHolder.setPersonalData(VehiclePersonalDataSection)
    }

    override fun createViewHolder(parent: ViewGroup?): VehiclePersonalDataGroupHolder {
        return VehiclePersonalDataGroupHolder(inflate(R.layout.vehicle_personal_data_group_item, parent))
    }

    interface Listener {
        fun onCategoryClicked(model: VehiclePersonalDataSection)
    }
}