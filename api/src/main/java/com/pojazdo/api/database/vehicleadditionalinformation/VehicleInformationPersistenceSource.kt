package com.pojazdo.api.database.vehicleadditionalinformation

import com.pojazdo.api.database.vehicleadditionalinformation.database.VehicleInformationDAO
import com.pojazdo.api.database.vehicleadditionalinformation.model.VehicleAdditionalInformation
import io.reactivex.Single
import javax.inject.Inject

class VehicleInformationPersistenceSource @Inject constructor (private val vehicleInformationDAO: VehicleInformationDAO) : VehicleInformationPersistenceApi {

    override fun getVehicleAdditionalInformation(vin: String): Single<VehicleAdditionalInformation> {
        return Single.just(vehicleInformationDAO.getVehicleInformation(vin))
    }

    override fun persistVehicleAdditionalInformation(vehicleAdditionalInformation: VehicleAdditionalInformation) {
        vehicleInformationDAO.insert(vehicleAdditionalInformation)
    }

    override fun updateVehicleAdditionalInformation(vehicleAdditionalInformation: VehicleAdditionalInformation) {
        vehicleInformationDAO.update(vehicleAdditionalInformation)
    }

    override fun getAllVehicleAdditionalInformation(): List<VehicleAdditionalInformation> {
     return   vehicleInformationDAO.getAllVehicleInformation()
    }

    override fun removeVehicleAdditionalInformation(vin: String) {
        vehicleInformationDAO.delete(vin)
    }
}