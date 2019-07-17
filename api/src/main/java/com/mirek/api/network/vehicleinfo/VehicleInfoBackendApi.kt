package com.mirek.api.network.vehicleinfo

import com.mirek.api.network.vehicleinfo.model.VehicleInfoResponse
import io.reactivex.Single

interface VehicleInfoBackendApi {

    fun checkVehicle(baseURL: String, registrationNumber: String, vin: String, dateOfFirstRegistration: String): Single<VehicleInfoResponse>
}