package com.pojazdo.architecture.ui.summary.model.modelsection

import com.pojazdo.architecture.ui.summary.model.modelsubsection.VehicleSubsection


class VehicleTitleSection(title: String, items: List<VehicleSubsection>, hasInitExpandableState: Boolean) : VehicleSections(title, items, hasInitExpandableState) {
    override fun checkVehicleSectionType(): SectionType.VehicleSectionType = SectionType.VehicleSectionType.VEHICLE_TITLE_GROUP
}