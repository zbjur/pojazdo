package com.pojazdo.usecases.vehicleInformation

import com.pojazdo.api.network.vehicleinformation.model.VehicleInformationPojo
import io.reactivex.Single

interface VehicleInformationApi {
    fun checkVehicleInformation(vin: String,
                                registrationNumber: String,
                                date: String): Single<VehicleInformationPojo>
}