package com.pojazdo.api.network.vehicletrader

import com.pojazdo.api.network.vehicletrader.model.VehicleOfferedPojo
import io.reactivex.Single

interface VehicleTraderBackendApi {
    fun getVehicleOffers(baseUrl: String, brand: String, model: String): Single<VehicleOfferedPojo>
    fun getAveragePriceForVehicle(baseUrl: String, brand: String, model: String): Single<String>
}