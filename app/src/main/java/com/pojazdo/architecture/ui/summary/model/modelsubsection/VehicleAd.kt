package com.pojazdo.architecture.ui.summary.model.modelsubsection

class VehicleAd(val brand: String, val model: String, val imageUrl: String, val htmlUrl: String, val engine: String, val price: String) : SubSectionType {
    override fun checkVehicleSubSectionType() = SubSectionType.VehicleSubSectionType.VEHICLE_ADS
}