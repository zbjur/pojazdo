package com.pojazdo.api.network.vehicleinformation

import com.pojazdo.api.network.vehicleinformation.model.VehicleInformationPojo
import io.reactivex.Single

interface VehicleInforamtionBackendApi {

    fun fetchVehicleInformation(baseURL: String, registrationNumber: String, vin: String, dateOfFirstRegistration: String): Single<VehicleInformationPojo>
}