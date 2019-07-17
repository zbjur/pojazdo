package com.pojazdo.api.network.vehiclehtmlparser

import com.pojazdo.api.network.parser.model.VehicleRatingSummaryPojo
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface VehicleHtmlParserRetrofitApi {

    @GET("?format=json&groupId=\'home\'")
    fun parseVehicleHistoryHtmlResponse(@Query("vehicleHistoryHtml") vehicleHistoryHtmlString: String): Single<VehicleHistoryPojo>

    @GET("?format=json&groupId=\'home\'")
    fun parseVehicleRatingHtmlResponse(@Query("vehicleRatingHtml") vehicleRatingHtmlString: String): Single<VehicleRatingSummaryPojo>
}