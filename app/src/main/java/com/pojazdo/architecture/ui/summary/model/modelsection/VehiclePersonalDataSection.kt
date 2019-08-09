package com.pojazdo.architecture.ui.summary.model.modelsection

import com.pojazdo.architecture.ui.summary.model.modelsubsection.VehicleSubsection

class VehiclePersonalDataSection(val city: String?,
                                 val street: String?,
                                 subsectionList: List<VehicleSubsection>,
                                 hasInitExpandableState: Boolean) : VehicleSections("", subsectionList, false) {

    override fun checkVehicleSectionType() = SectionType.VehicleSectionType.VEHICLE_PERSONAL_DATA_GROUP
}