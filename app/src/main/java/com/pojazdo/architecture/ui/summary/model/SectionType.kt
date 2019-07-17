package com.pojazdo.architecture.ui.summary.model

interface SectionType {

    fun checkVehicleSectionType(): VehicleSectionType

    enum class VehicleSectionType {
        VEHICLE_MAIN_INFO,
        VEHICLE_TIMELINE,
        VEHICLE_RATING,
        VEHICLE_PRICE,
        VEHICLE_ADS,
        VEHICLE_LOCATION
    }
}