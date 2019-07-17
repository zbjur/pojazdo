package com.pojazdo.usecases.vehicletrader

import com.pojazdo.api.network.vehicletrader.VehicleTraderBackendApi
import com.pojazdo.api.network.vehicletrader.model.VehicleOfferedPojo
import io.reactivex.Single
import javax.inject.Inject

class VehicleTraderService @Inject constructor(private val vehicleTraderBackendApi: VehicleTraderBackendApi) : VehicleTraderApi {
    override fun getVehicleOffers(brand: String?, model: String?): Single<VehicleOfferedPojo> {
        return vehicleTraderBackendApi.getVehicleOffers("", "", "")
    }

    override fun getAveragePriceForVehicle(brand: String?, model: String?): Single<String> {
        return vehicleTraderBackendApi.getAveragePriceForVehicle("", "", "")
    }
}
