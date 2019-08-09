package com.pojazdo.architecture.ui.summary.model.modelsubsection

import com.pojazdo.architecture.ui.summary.model.modelsubsection.SubSectionType

class VehicleRatingSubSection(val title: String, val rating: String) : SubSectionType {
    override fun checkVehicleSubSectionType() = SubSectionType.VehicleSubSectionType.VEHICLE_RATING }
