package com.pojazdo.api.network.vehicletrader

import com.pojazdo.api.network.vehiclehtmlparser.model.VehicleInfo
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface VehicleTraderRetrofitApi{

    @GET("?format=json&groupId=\'home\'")
    fun getVehicleInfo(@Query("Country") country: String): Single<VehicleInfo>
}