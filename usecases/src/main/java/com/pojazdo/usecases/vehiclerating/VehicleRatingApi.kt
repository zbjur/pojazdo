package com.pojazdo.usecases.vehiclerating

import com.pojazdo.api.network.parser.model.VehicleRatingSummaryPojo
import io.reactivex.Single

interface VehicleRatingApi {
    fun checkVehicleRating(brand: String?,
                           model: String?) : Single<VehicleRatingSummaryPojo>
}