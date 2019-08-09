package com.pojazdo.architecture.ui.summary.model.modelsubsection

import com.pojazdo.architecture.ui.summary.model.modelsubsection.SubSectionType

data class VehicleUserRatingSubSection(val rating: String,
                                       val user: String,
                                       val model: String,
                                       val type: String,
                                       val comment: String) : SubSectionType {
    override fun checkVehicleSubSectionType() = SubSectionType.VehicleSubSectionType.VEHICLE_USER_RATING }