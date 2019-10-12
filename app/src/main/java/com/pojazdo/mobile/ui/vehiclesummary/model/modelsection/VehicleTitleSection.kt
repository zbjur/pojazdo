package com.pojazdo.mobile.ui.vehiclesummary.model.modelsection

import com.pojazdo.mobile.ui.vehiclesummary.model.modelsubsection.VehicleSubsection


class VehicleTitleSection(title: String, items: List<VehicleSubsection>, hasInitExpandableState: Boolean) : VehicleSections(title, items, hasInitExpandableState) {
    override fun checkVehicleSectionType(): SectionType.VehicleSectionType = SectionType.VehicleSectionType.VEHICLE_TITLE_GROUP
}