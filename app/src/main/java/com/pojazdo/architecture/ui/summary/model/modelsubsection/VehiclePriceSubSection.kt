package com.pojazdo.architecture.ui.summary.model.modelsubsection

import com.pojazdo.architecture.ui.summary.model.modelsubsection.SubSectionType

class VehiclePriceSubSection (val minPrice: String?,
                              val maxPrice: String?,
                              val avgPrice: String?): SubSectionType {
    override fun checkVehicleSubSectionType() = SubSectionType.VehicleSubSectionType.VEHICLE_PRICE
}