package com.pojazdo.mobile.ui.vehiclesummary.model.modelsection

interface SectionType {

    fun checkVehicleSectionType(): VehicleSectionType

    enum class VehicleSectionType {
        VEHICLE_TITLE_GROUP,
        VEHICLE_SUMMARY_INFO_GROUP,
        VEHICLE_PERSONAL_DATA_GROUP,
        VEHICLE_MAP_GROUP///
    }
}