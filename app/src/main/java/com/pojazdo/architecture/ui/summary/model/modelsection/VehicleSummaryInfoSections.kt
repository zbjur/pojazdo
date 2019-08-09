package com.pojazdo.architecture.ui.summary.model.modelsection

import com.pojazdo.architecture.ui.summary.model.modelsubsection.VehicleSubsection

data class VehicleSummaryInfoSections(val brand: String?,
                                      val model: String?,
                                      val yearOfProduction: Int?,
                                      val vin: String?,
                                      val engineCapacity: String?,
                                      val insurance: String?,
                                      val technicalExamination: String?,
                                      val lastMeterState: String?,
                                      val registrationState: String?,
                                      val capacity: String?,
                                      val fuel: String?,
                                      val alternativeFuel: String?,
                                      val subsectionList: List<VehicleSubsection>,
                                      val hasInitExpandableState: Boolean) : VehicleSections("", subsectionList, hasInitExpandableState) {

    override fun checkVehicleSectionType() = SectionType.VehicleSectionType.VEHICLE_SUMMARY_INFO_GROUP
}





