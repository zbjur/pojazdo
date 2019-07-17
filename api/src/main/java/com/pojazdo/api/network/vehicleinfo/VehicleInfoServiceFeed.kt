package com.pojazdo.api.network.vehicleinfo

import com.pojazdo.api.network.base.DynamicUrlService
import com.pojazdo.api.network.vehicleinformation.model.VehicleInformationPojo
import io.reactivex.Single
import okhttp3.OkHttpClient
import javax.inject.Inject

class VehicleInfoServiceFeed @Inject constructor(client: OkHttpClient) : DynamicUrlService<VehicleInfoRetrofitApi>(client = client), VehicleInfoBackendApi {
    override fun checkVehicleHistory(baseUrl: String, registrationNumber: String, vin: String, dateOfFirtsRegistration: String): Single<VehicleInformationPojo> {

        return Single.just(VehicleInformationPojo("", "", 0, "", "",
                "", "", "", "", "", "", "", null, null
                , null, null, null))
    }

    override fun getGenericParameter(): Class<VehicleInfoRetrofitApi> = VehicleInfoRetrofitApi::class.java
}


