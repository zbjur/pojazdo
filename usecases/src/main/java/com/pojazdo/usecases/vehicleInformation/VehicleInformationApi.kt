package com.pojazdo.usecases.vehicleInformation

import com.pojazdo.api.database.vehicleadditionalinformation.model.Seller
import com.pojazdo.api.database.vehicleadditionalinformation.model.VehicleAndSellerInformation
import com.pojazdo.api.network.vehicleinformation.model.VehicleInformation
import io.reactivex.Single

interface VehicleInformationApi {

    fun checkVehicleInformation(vin: String,
                                registrationNumber: String,
                                date: String): Single<VehicleInformation>

    fun checkVehicleInformation(qrCode: String): Single<VehicleInformation>

    fun loadVehicleInformation(): Single<List<VehicleAndSellerInformation>>

    fun editPersonalSellerData(seller : Seller)
}