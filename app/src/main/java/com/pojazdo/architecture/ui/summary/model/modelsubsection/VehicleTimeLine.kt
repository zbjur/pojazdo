package com.pojazdo.architecture.ui.summary.model.modelsubsection

import com.pojazdo.api.network.vehicleinformation.model.Description
import com.pojazdo.architecture.ui.summary.model.modelsubsection.SubSectionType

class VehicleTimeLine(val date: String, val descriptions: List<Description>?) : SubSectionType {
    override fun checkVehicleSubSectionType() = SubSectionType.VehicleSubSectionType.VEHICLE_TIMELINE
}