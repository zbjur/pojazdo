package com.pojazdo.api.database.vehicleadditionalinformation

import com.pojazdo.api.database.vehicleadditionalinformation.model.VehicleAddiotionalInformationPojo

interface VehicleAdditionalInformationPersistenceApi {

    fun getVehicleAdditionalInformation(vin: String) : VehicleAddiotionalInformationPojo

    fun perVehicleAdditionalInformation(vehicleAdditionalInformationPojo: VehicleAddiotionalInformationPojo)
}