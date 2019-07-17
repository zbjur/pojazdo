package com.pojazdo.architecture.ui.summary.model

class VehicleTimeLine(val date: String, val value: String, val events: List<Event>?) : SectionType {
    override fun checkVehicleSectionType() = SectionType.VehicleSectionType.VEHICLE_TIMELINE
}