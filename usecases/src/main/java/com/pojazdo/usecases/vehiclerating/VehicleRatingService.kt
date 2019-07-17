package com.pojazdo.usecases.vehiclerating

import com.pojazdo.api.network.parser.model.VehicleRatingSummaryPojo
import com.pojazdo.api.network.vehiclerating.VehicleRatingBackendApi
import com.pojazdo.api.network.vehiclerating.model.VehicleRatingHtmlStringResponse
import com.pojazdo.usecases.vehiclehtmlparser.VehicleHtmlParserApi
import io.reactivex.Single
import javax.inject.Inject

class VehicleRatingService @Inject constructor(private val vehicleRatingBackendApi: VehicleRatingBackendApi,
                                               private val vehicleHtmlParserParserApi: VehicleHtmlParserApi) : VehicleRatingApi {
    override fun checkVehicleRating(brand: String?, model: String?): Single<VehicleRatingSummaryPojo> {
      return vehicleRatingBackendApi.checkVehicleRating("","","")
              .flatMap { t: VehicleRatingHtmlStringResponse ->
                  vehicleHtmlParserParserApi.parseVehicleRatingHtmlResponse(t.htmlStringResponse)
              }
    }
}