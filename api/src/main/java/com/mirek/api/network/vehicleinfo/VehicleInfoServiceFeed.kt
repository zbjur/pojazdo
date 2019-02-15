package com.mirek.api.network.vehicleinfo

import com.mirek.api.network.base.DynamicUrlService
import com.mirek.api.network.vehicleinfo.model.VehicleInfoResponse
import io.reactivex.Single
import okhttp3.OkHttpClient
import javax.inject.Inject

class VehicleInfoServiceFeed @Inject constructor(client: OkHttpClient) :
        DynamicUrlService<VehicleInfoRetrofitApi>(client = client), VehicleInfoBackendApi {
    override fun checkVehicle(baseUrl: String, registrationNumber: String, vin: String, dateOfFirtsRegistration: String):
            Single<VehicleInfoResponse> {
        return Single.just(VehicleInfoResponse(""))
        //return restAdapter(baseUrl).checkVehicle(registrationNumber, vin, dateOfFirtsRegistration)
    }

    override fun getGenericParameter(): Class<VehicleInfoRetrofitApi> = VehicleInfoRetrofitApi::class.java
}


