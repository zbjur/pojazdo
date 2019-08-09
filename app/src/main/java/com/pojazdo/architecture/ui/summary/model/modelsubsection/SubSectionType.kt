package com.pojazdo.architecture.ui.summary.model.modelsubsection

interface SubSectionType {

    fun checkVehicleSubSectionType(): VehicleSubSectionType

    enum class VehicleSubSectionType {
        VEHICLE_MAIN_INFO,
        VEHICLE_TIMELINE,
        VEHICLE_OVERALL_RATING,
        VEHICLE_RATING,
        VEHICLE_ENGINE_RATING,
        VEHICLE_USER_RATING,
        VEHICLE_PRICE,
        VEHICLE_ADS,
        VEHICLE_PERSONAL_DATA_CHILD
    }
}