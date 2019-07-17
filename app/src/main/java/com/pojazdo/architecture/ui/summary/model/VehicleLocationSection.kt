package com.pojazdo.architecture.ui.summary.model

class VehicleLocationSection (val key: String, val value: String) :  SectionType {
    override fun checkVehicleSectionType() = SectionType.VehicleSectionType.VEHICLE_LOCATION
}