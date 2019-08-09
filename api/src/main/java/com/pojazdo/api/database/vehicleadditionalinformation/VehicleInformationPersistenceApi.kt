package com.pojazdo.api.database.vehicleadditionalinformation

import com.pojazdo.api.database.vehicleadditionalinformation.model.VehicleAdditionalInformation
import io.reactivex.Single

interface VehicleInformationPersistenceApi {

    fun updateVehicleAdditionalInformation(vehicleAdditionalInformation: VehicleAdditionalInformation)

    fun persistVehicleAdditionalInformation(vehicleAdditionalInformation: VehicleAdditionalInformation)

    fun getVehicleAdditionalInformation(vin: String): Single<VehicleAdditionalInformation>

    fun getAllVehicleAdditionalInformation(): List<VehicleAdditionalInformation>

    fun removeVehicleAdditionalInformation(vin: String)
}