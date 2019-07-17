package com.pojazdo.usecases.vehiclehtmlparser

import com.pojazdo.api.network.parser.model.VehicleRatingSummaryPojo
import com.pojazdo.api.network.vehiclehtmlparser.VehicleHistoryPojo
import com.pojazdo.api.network.vehicleinfo.model.VehicleHistoryHtmlResponse
import io.reactivex.Single

interface VehicleHtmlParserApi {
    fun parseVehicleHistoryHtmlResponse(vehicleHtmlResponse: VehicleHistoryHtmlResponse): Single<VehicleHistoryPojo>
    fun parseVehicleRatingHtmlResponse(vehicleRatingHtmlString: String): Single<VehicleRatingSummaryPojo>
}