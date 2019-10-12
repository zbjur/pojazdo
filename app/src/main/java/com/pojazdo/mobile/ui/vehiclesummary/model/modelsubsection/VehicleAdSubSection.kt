package com.pojazdo.mobile.ui.vehiclesummary.model.modelsubsection

class VehicleAdSubSection(val vehicleOfferSections: List<VehicleOffersSection>) : SubSectionType {
    override fun checkVehicleSubSectionType() = SubSectionType.VehicleSubSectionType.VEHICLE_ADS
}