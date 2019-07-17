package com.pojazdo.api.network.vehicleinformation

import com.pojazdo.api.network.base.DynamicUrlService
import com.pojazdo.api.network.vehicleinformation.model.VehicleInformationPojo
import io.reactivex.Single
import okhttp3.OkHttpClient
import javax.inject.Inject

class VehicleInformationServiceFeed @Inject constructor(client: OkHttpClient) : DynamicUrlService<VehicleInformationRetrofitApi>(client = client), VehicleInforamtionBackendApi {
    override fun fetchVehicleInformation(baseUrl: String, registrationNumber: String, vin: String, dateOfFirtsRegistration: String): Single<VehicleInformationPojo> {

        return Single.just(VehicleInformationPojo("", "", 0, "", "",
                "", "", "", "", "", "", "", null, null
                , null, null, null))
    }

    override fun getGenericParameter(): Class<VehicleInformationRetrofitApi> = VehicleInformationRetrofitApi::class.java
}


