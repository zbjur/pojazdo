package com.pojazdo.mobile.ui.vehiclesummary.list.saleoffers

import android.view.ViewGroup

import com.github.vivchar.rendererrecyclerviewadapter.ViewRenderer
import com.pojazdo.mobile.R
import com.pojazdo.mobile.ui.vehiclesummary.model.modelsubsection.VehicleOffersSection

class VehicleSaleOffersViewRenderer : ViewRenderer<VehicleOffersSection, VehicleSaleOffersHolder>(VehicleOffersSection::class.java) {

    override fun bindView(VehicleOffersSection: VehicleOffersSection, vehicleModelHolder: VehicleSaleOffersHolder) {
        vehicleModelHolder.setVehicleSaleOffer(VehicleOffersSection)
    }

    override fun createViewHolder(parent: ViewGroup?): VehicleSaleOffersHolder {
        return VehicleSaleOffersHolder(inflate(R.layout.vehicle_sale_offer_item, parent),context)
    }

    interface Listener {
        fun onCategoryClicked(model: VehicleOffersSection)
    }
}