package com.pojazdo.usecases.vehiclehtmlparser


import com.pojazdo.api.network.parser.model.VehicleRatingSummaryPojo
import com.pojazdo.api.network.vehiclehtmlparser.VehicleHistoryPojo
import com.pojazdo.api.network.vehiclehtmlparser.VehicleHtmlParserBackendApi
import com.pojazdo.api.network.vehicleinfo.model.VehicleHistoryHtmlResponse
import io.reactivex.Single
import javax.inject.Inject

class VehicleHtmlParserService @Inject constructor(private val vehicleHtmlParserBackendApi: VehicleHtmlParserBackendApi) : VehicleHtmlParserApi {

    override fun parseVehicleHistoryHtmlResponse(vehicleHtmlResponse: VehicleHistoryHtmlResponse): Single<VehicleHistoryPojo> {
        return vehicleHtmlParserBackendApi.parseVehicleHistoryHtmlResponse("", "")
    }

    override fun parseVehicleRatingHtmlResponse(vehicleRatingHtmlString: String): Single<VehicleRatingSummaryPojo> {
        return vehicleHtmlParserBackendApi.parseVehicleRatingHtmlResponse("", "")
    }
}