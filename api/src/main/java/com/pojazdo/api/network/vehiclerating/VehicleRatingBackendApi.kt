package com.pojazdo.api.network.vehiclerating

import com.pojazdo.api.network.vehiclerating.model.VehicleRatingHtmlStringResponse
import io.reactivex.Single

interface VehicleRatingBackendApi {
    fun checkVehicleRating(baseUrl: String, brand: String, model: String): Single<VehicleRatingHtmlStringResponse>
}