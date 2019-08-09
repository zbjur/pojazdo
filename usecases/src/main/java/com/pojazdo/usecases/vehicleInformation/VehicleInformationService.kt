package com.pojazdo.usecases.vehicleInformation

import com.pojazdo.api.database.vehicleadditionalinformation.VehicleInformationPersistenceApi
import com.pojazdo.api.database.vehicleadditionalinformation.model.VehicleAdditionalInformation
import com.pojazdo.api.network.vehicleinformation.VehicleInformationBackendApi
import com.pojazdo.api.network.vehicleinformation.model.VehicleInformation
import io.reactivex.Single
import javax.inject.Inject

open class VehicleInformationService @Inject constructor(private val vehicleInfoBackendApi: VehicleInformationBackendApi,
                                                         private val vehicleInformationPersistenceApi: VehicleInformationPersistenceApi) : VehicleInformationApi {


    override fun checkVehicleInformation(vin: String, registrationNumber: String, registrationDate: String): Single<VehicleInformation> {


        return vehicleInfoBackendApi.fetchVehicleInformation("param", registrationNumber, vin, registrationDate)
          /*      .flatMap { vi ->
                    vehicleInformationPersistenceApi.getVehicleAdditionalInformation(vi.vin)
                            .map { va ->
                                matchVehicleInfoWIthAdditionalInfo(vi, va)
                            }
                }
                .doAfterSuccess {
                    vehicleInformationPersistenceApi.persistVehicleAdditionalInformation(VehicleAdditionalInformation(it.vin, registrationDate, registrationNumber))
                }*/
    }


    private fun matchVehicleInfoWIthAdditionalInfo(vi: VehicleInformation, va: VehicleAdditionalInformation): VehicleInformation {
        vi.vehicleAdditionalInformation = va
        return vi
    }

    override fun checkVehicleInformation(qrCode: String): Single<VehicleInformation> {
        return vehicleInfoBackendApi.fetchVehicleInformation("url", qrCode)
                .doAfterSuccess {
                    /* vehicleInformationPersistenceApi.persistVehicleAdditionalInformation(VehicleAdditionalInformation(it.vin,
                             it.registrationState,
                             "",
                             0.0,
                             0.0,
                             "test ",
                             "test email"))*/
                }
    }
}