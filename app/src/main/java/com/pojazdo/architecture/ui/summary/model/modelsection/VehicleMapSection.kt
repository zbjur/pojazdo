package com.pojazdo.architecture.ui.summary.model.modelsection


class VehicleMapSection(val latitiude: Double?,val longtitiude: Double?, hasInitExpandableState: Boolean) : VehicleSections("", emptyList(), hasInitExpandableState) {
    override fun checkVehicleSectionType(): SectionType.VehicleSectionType = SectionType.VehicleSectionType.VEHICLE_MAP_GROUP
}