package com.pojazdo.architecture.ui.summary.model

data class VehicleMainInfoSubsections(val brand: String, val key: String, val model: String) :  SectionType {
    override fun checkVehicleSectionType() = SectionType.VehicleSectionType.VEHICLE_MAIN_INFO
}





