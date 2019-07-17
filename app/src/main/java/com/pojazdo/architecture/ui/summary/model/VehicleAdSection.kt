package com.pojazdo.architecture.ui.summary.model

class VehicleAdSection(val vehicleAds: List<VehicleAd>) : SectionType {
    override fun checkVehicleSectionType() = SectionType.VehicleSectionType.VEHICLE_ADS
}