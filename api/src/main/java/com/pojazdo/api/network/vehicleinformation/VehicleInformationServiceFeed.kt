package com.pojazdo.api.network.vehicleinformation

import com.google.common.base.Charsets
import com.google.common.io.Resources
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.pojazdo.api.network.base.DynamicUrlService
import com.pojazdo.api.network.vehicleinformation.model.VehicleInformation
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockWebServer
import javax.inject.Inject

class VehicleInformationServiceFeed @Inject constructor(client: OkHttpClient, mockServer: MockWebServer) : DynamicUrlService<VehicleInformationRetrofitApi>(client = client), VehicleInformationBackendApi {
    override fun fetchVehicleInformation(baseURL: String, qCode: String): Single<VehicleInformation> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

/*
    override fun fetchVehicleInformation(qCode: String): Single<VehicleInformation> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
*/

    override fun fetchVehicleInformation(baseUrl: String, registrationNumber: String, vin: String, dateOfFirtsRegistration: String): Single<VehicleInformation> {
        val jsonStringResponse = Resources.toString(Resources.getResource("json/vehicle_information.json"), Charsets.UTF_8)
        val gson = Gson()
        val listType = object : TypeToken<VehicleInformation>() { }.type
        val vehicleInformationPojo = gson.fromJson<VehicleInformation>(jsonStringResponse, listType)

        return Single.just(vehicleInformationPojo)
    }

    override fun getGenericParameter(): Class<VehicleInformationRetrofitApi> = VehicleInformationRetrofitApi::class.java
}


