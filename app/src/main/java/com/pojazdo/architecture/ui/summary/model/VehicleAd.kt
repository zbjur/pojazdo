package com.pojazdo.architecture.ui.summary.model

class VehicleAd(val brand: String, val model: String, val url: String, val engine: String, val price: String) : SectionType {
    override fun checkVehicleSectionType() = SectionType.VehicleSectionType.VEHICLE_ADS
}