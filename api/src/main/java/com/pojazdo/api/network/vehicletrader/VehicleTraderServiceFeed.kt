package com.pojazdo.api.network.vehicletrader

import com.pojazdo.api.network.vehicletrader.model.VehicleOfferedPojo
import io.reactivex.Single
import javax.inject.Inject

class VehicleTraderServiceFeed @Inject constructor() : VehicleTraderBackendApi {

    override fun getVehicleOffers(baseUrl: String, brand: String, model: String) =
            Single.just(VehicleOfferedPojo("Sedan","Roomster","","Skoda","LPG","2010","27.000","LPG"))

    override fun getAveragePriceForVehicle(baseUrl: String, brand: String, model: String) = Single.just("24.000 zł")
}