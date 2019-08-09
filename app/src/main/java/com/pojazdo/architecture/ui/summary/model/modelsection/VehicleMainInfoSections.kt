package com.pojazdo.architecture.ui.summary.model.modelsection

data class VehicleMainInfoSections(val brand: String?,
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
                                   val hasInitExpandableState: Boolean) : VehicleSections("", emptyList(), hasInitExpandableState) {

    override fun checkVehicleSectionType() = SectionType.VehicleSectionType.VEHICLE_MAIN_INFO_GROUP
}





