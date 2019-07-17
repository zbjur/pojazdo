package com.pojazdo.usecases.vehicletrader

import com.pojazdo.api.network.vehicletrader.model.VehicleOfferedPojo
import io.reactivex.Single

interface VehicleTraderApi {
    fun getVehicleOffers(brand: String?, model: String?): Single<VehicleOfferedPojo>
    fun getAveragePriceForVehicle(brand: String?, model: String?): Single<String>
}