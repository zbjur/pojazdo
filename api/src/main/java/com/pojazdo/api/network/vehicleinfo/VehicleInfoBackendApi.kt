package com.pojazdo.api.network.vehicleinfo

import com.pojazdo.api.network.vehicleinformation.model.VehicleInformationPojo
import io.reactivex.Single

interface VehicleInfoBackendApi {

    fun checkVehicleHistory(baseURL: String, registrationNumber: String, vin: String, dateOfFirstRegistration: String): Single<VehicleInformationPojo>
}