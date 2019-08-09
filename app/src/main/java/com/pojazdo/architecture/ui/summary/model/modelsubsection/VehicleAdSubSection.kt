package com.pojazdo.architecture.ui.summary.model.modelsubsection

class VehicleAdSubSection(val vehicleAds: List<VehicleAd>) : SubSectionType {
    override fun checkVehicleSubSectionType() = SubSectionType.VehicleSubSectionType.VEHICLE_ADS
}