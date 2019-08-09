package com.pojazdo.architecture.ui.summary.model.modelsubsection

data class VehicleEngineRatingSubSection(val engineName: String, val rating: String, val url: String) : SubSectionType {
    override fun checkVehicleSubSectionType() = SubSectionType.VehicleSubSectionType.VEHICLE_ENGINE_RATING
}