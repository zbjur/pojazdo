package com.pojazdo.architecture.ui.summary.model.modelsubsection

data class VehicleDetailsInfoSections(val brand: String?,
                                      val model: String?) : SubSectionType {

    override fun checkVehicleSubSectionType() = SubSectionType.VehicleSubSectionType.VEHICLE_DETAILS_INFO
}





