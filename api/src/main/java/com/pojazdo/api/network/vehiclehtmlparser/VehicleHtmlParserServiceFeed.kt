package com.pojazdo.api.network.vehiclehtmlparser

import com.google.common.base.Charsets
import com.google.common.io.Resources
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.pojazdo.api.network.base.DynamicUrlService
import com.pojazdo.api.network.parser.model.VehicleRatingSummaryPojo
import io.reactivex.Single
import okhttp3.OkHttpClient
import javax.inject.Inject

class VehicleHtmlParserServiceFeed @Inject constructor(client: OkHttpClient) : DynamicUrlService<VehicleHtmlParserRetrofitApi>(client),
        VehicleHtmlParserBackendApi {

    override fun parseVehicleHistoryHtmlResponse(baseUrl: String, vehicleHistoryHtmlString: String): Single<VehicleHistoryPojo> {
        val jsonStringResponse = Resources.toString(Resources.getResource("json/vehicle_history.json"), Charsets.UTF_8)
        val gson = Gson()
     /*   val jsonString = gson.toJson(jsonStringResponse)*/
        val listType = object : TypeToken<VehicleHistoryPojo>() { }.type
        val response = gson.fromJson<VehicleHistoryPojo>(jsonStringResponse, listType)
        return Single.just(response)
    }

    override fun parseVehicleRatingHtmlResponse(baseUrl: String, vehicleRatingHtmlString: String): Single<VehicleRatingSummaryPojo> {
        print("parseVehicleRatingHtmlResponse${Thread.currentThread().name}")
        val jsonStringResponse = Resources.toString(Resources.getResource("json/vehicle_rating_summary.json"), Charsets.UTF_8)
        val gson = Gson()
        val listType = object : TypeToken<VehicleRatingSummaryPojo>() { }.type
        val response = gson.fromJson<VehicleRatingSummaryPojo>(jsonStringResponse, listType)
        return Single.just(response)
        
    }

    override fun getGenericParameter(): Class<VehicleHtmlParserRetrofitApi> = VehicleHtmlParserRetrofitApi::class.java
}