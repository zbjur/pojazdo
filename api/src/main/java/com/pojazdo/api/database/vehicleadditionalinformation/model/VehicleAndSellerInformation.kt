package com.pojazdo.api.database.vehicleadditionalinformation.model

import androidx.room.Embedded
import androidx.room.Relation

class VehicleAndSellerInformation {

    @Embedded
    lateinit var vehicleAdditionalInformation: VehicleAdditionalInformation

    @Relation(parentColumn = "id", entityColumn = "vehicle_id")
    var seller:  List<Seller> = arrayListOf()
}