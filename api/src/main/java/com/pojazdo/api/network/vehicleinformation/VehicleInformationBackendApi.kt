package com.pojazdo.api.network.vehicleinformation

import com.pojazdo.api.network.vehicleinformation.model.VehicleInformation
import io.reactivex.Single

interface VehicleInformationBackendApi {

    fun fetchVehicleInformation(baseURL: String, vin: String, registrationNumber: String, dateOfFirstRegistration: String): Single<VehicleInformation>

    fun fetchVehicleInformation(baseURL: String, qCode: String): Single<VehicleInformation>
}