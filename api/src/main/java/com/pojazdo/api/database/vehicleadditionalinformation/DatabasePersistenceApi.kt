package com.pojazdo.api.database.vehicleadditionalinformation

import com.pojazdo.api.database.vehicleadditionalinformation.model.Seller
import com.pojazdo.api.database.vehicleadditionalinformation.model.VehicleAdditionalInformation
import com.pojazdo.api.database.vehicleadditionalinformation.model.VehicleAndSellerInformation
import io.reactivex.Single

interface DatabasePersistenceApi {

    fun updateVehicleAdditionalInformation(vehicleAdditionalInformation: VehicleAdditionalInformation)

    fun persistVehicleAdditionalInformation(vehicleAdditionalInformation: VehicleAdditionalInformation)

    fun getVehicleAdditionalInformation(vin: String): Single<VehicleAndSellerInformation>

    fun getAllVehicleAdditionalInformation(): Single<List<VehicleAndSellerInformation>>

    fun removeVehicleAdditionalInformation(vin: String)

    fun persistSeller(seller: Seller)

    fun updateSeller(seller: Seller)

    fun getSeller(id: Int) : Single<Seller>
}