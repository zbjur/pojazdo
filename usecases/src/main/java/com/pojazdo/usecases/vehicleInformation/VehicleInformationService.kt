package com.pojazdo.usecases.vehicleInformation

import com.pojazdo.api.database.vehicleadditionalinformation.DatabasePersistenceApi
import com.pojazdo.api.database.vehicleadditionalinformation.model.Seller
import com.pojazdo.api.database.vehicleadditionalinformation.model.VehicleAdditionalInformation
import com.pojazdo.api.database.vehicleadditionalinformation.model.VehicleAndSellerInformation
import com.pojazdo.api.network.vehicleinformation.VehicleInformationBackendApi
import com.pojazdo.api.network.vehicleinformation.model.VehicleInformation
import io.reactivex.Single
import javax.inject.Inject

open class VehicleInformationService @Inject constructor(private val vehicleInfoBackendApi: VehicleInformationBackendApi,
                                                         private val databasePersistenceApi: DatabasePersistenceApi) : VehicleInformationApi {


    override fun checkVehicleInformation(vin: String, registrationNumber: String, registrationDate: String): Single<VehicleInformation> {

        return vehicleInfoBackendApi.fetchVehicleInformation("param", registrationNumber, vin, registrationDate)
                .doAfterSuccess {
                    databasePersistenceApi.persistVehicleAdditionalInformation(VehicleAdditionalInformation(
                            brand = it.brand,
                            model = it.model,
                            year = it.yearOfProduction.toString(),
                            vin = vin,
                            firstRegistrationDate = registrationDate,
                            registrationNumber = registrationNumber))
                }
    }

    override fun editPersonalSellerData(seller: Seller) {
        return databasePersistenceApi.persistSeller(seller)
    }

    override fun loadVehicleInformation(): Single<List<VehicleAndSellerInformation>> {
       return databasePersistenceApi.getAllVehicleAdditionalInformation()
    }



    private fun matchVehicleInfoWIthAdditionalInfo(vi: VehicleInformation, va: VehicleAndSellerInformation): VehicleInformation {
        vi.vehicleAndSellerInformation = va
        return vi
    }

    override fun checkVehicleInformation(qrCode: String): Single<VehicleInformation> {
        return vehicleInfoBackendApi.fetchVehicleInformation("url", qrCode)
                .doAfterSuccess {
                    /* databasePersistenceApi.persistVehicleAdditionalInformation(VehicleAdditionalInformation(it.vin,
                             it.registrationState,
                             "",
                             0.0,
                             0.0,
                             "test ",
                             "test email"))*/
                }
    }
}