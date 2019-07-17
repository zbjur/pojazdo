package com.pojazdo.api.network.vehiclehtmlparser

import com.pojazdo.api.network.parser.model.VehicleRatingSummaryPojo
import io.reactivex.Single

interface VehicleHtmlParserBackendApi {
    fun parseVehicleHistoryHtmlResponse(baseUrl: String, vehicleHistoryHtmlString: String): Single<VehicleHistoryPojo>
    fun parseVehicleRatingHtmlResponse(baseUrl: String, vehicleRatingHtmlString: String): Single<VehicleRatingSummaryPojo>
}