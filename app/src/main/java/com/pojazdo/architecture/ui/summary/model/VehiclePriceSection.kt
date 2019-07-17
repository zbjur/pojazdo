package com.pojazdo.architecture.ui.summary.model

class VehiclePriceSection (val minPrice: String, val maxPrice: String, val avgPrice: String): SectionType {
    override fun checkVehicleSectionType() = SectionType.VehicleSectionType.VEHICLE_PRICE
}