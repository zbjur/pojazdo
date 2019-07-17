package com.pojazdo.architecture.ui.summary.model

class VehicleRatingSection(val user: String, val brand: String, val model: String, val rating: String, val ratingText: String) : SectionType {
    override fun checkVehicleSectionType() = SectionType.VehicleSectionType.VEHICLE_RATING
}