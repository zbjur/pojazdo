package com.pojazdo.architecture.ui.summary.model.modelsubsection

import com.pojazdo.architecture.ui.summary.model.modelsubsection.SubSectionType

data class VehicleOverallRatingSubSection(val overallRating: String?,
                                          val overallTitle: String?,
                                          val buyAgainPercentage: String?,
                                          val buyAgainTitle: String?) : SubSectionType {
    override fun checkVehicleSubSectionType() = SubSectionType.VehicleSubSectionType.VEHICLE_OVERALL_RATING
}