package com.pojazdo.api.network.vehiclerating

import com.pojazdo.api.network.vehiclerating.model.VehicleRatingHtmlStringResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface VehicleRatingRetrofitApi {

    @GET("oceny/{brand}/{model}/")
    fun getVehicleRatingSummary(@Path("brand") brand: String,
                                @Path("model") model: String): Single<VehicleRatingHtmlStringResponse>
}