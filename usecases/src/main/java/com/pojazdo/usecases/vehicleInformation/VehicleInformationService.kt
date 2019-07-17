package com.pojazdo.usecases.vehicleInformation

import com.pojazdo.api.network.vehicleinformation.VehicleInforamtionBackendApi
import com.pojazdo.api.network.vehicleinformation.model.VehicleInformationPojo
import com.pojazdo.usecases.vehicleInformation.converter.VehicleInformationConverter
import io.reactivex.Single
import javax.inject.Inject

class VehicleInformationService @Inject constructor(private val vehicleInfoBackendApi: VehicleInforamtionBackendApi,
                                                    private val vehicleInformationConverter: VehicleInformationConverter) : VehicleInformationApi {
    override fun checkVehicleInformation(registrationNumber: String, vin: String, registrationDate: String): Single<VehicleInformationPojo> {
        vehicleInformationConverter.convertToVehicleInformationSection()
        return vehicleInfoBackendApi.fetchVehicleInformation("url", registrationNumber, vin, registrationDate)
    }
}