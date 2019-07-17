package com.pojazdo.api.network.vehiclerating

import com.pojazdo.api.network.base.DynamicUrlService
import com.pojazdo.api.network.vehiclerating.model.VehicleRatingHtmlStringResponse
import io.reactivex.Single
import okhttp3.OkHttpClient
import javax.inject.Inject

class VehicleRatingServiceFeed @Inject constructor(client: OkHttpClient) : DynamicUrlService<VehicleRatingRetrofitApi>(client), VehicleRatingBackendApi {

    override fun checkVehicleRating(baseUrl: String, brand: String, model: String) =
    //restAdapter("https://m.autocentrum.pl/").getVehicleRatingSummary(brand, model)

            Single.just(VehicleRatingHtmlStringResponse("Html response"))

    override fun getGenericParameter() = VehicleRatingRetrofitApi::class.java
}