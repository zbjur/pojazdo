package com.pojazdo.mobile.ui.vehiclesummary.model.modelsubsection

class VehicleRatingSubSection(val title: String, val rating: String) : SubSectionType {
    override fun checkVehicleSubSectionType() = SubSectionType.VehicleSubSectionType.VEHICLE_RATING }
