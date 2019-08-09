package com.pojazdo.architecture.ui.summary.model.modelsubsection

class VehiclePersonalDataSubSection(
        val email: String?,
        val phone: String?) : SubSectionType {

    override fun checkVehicleSubSectionType() = SubSectionType.VehicleSubSectionType.VEHICLE_PERSONAL_DATA_CHILD
}