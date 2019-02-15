package com.mirek.usecases.vehiclehtmlparser

import com.mirek.api.network.htmlparser.model.VehicleInfo
import com.mirek.api.network.vehicleinfo.model.VehicleInfoResponse
import io.reactivex.Single

interface VehicleHtmlParserApi {
    fun parseVehicleResponse(vehicleResponse: VehicleInfoResponse): Single<VehicleInfo>
}