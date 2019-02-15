package com.mirek.api.network.htmlparser

import com.mirek.api.network.htmlparser.model.VehicleInfo
import com.mirek.api.network.vehicledecoder.model.VehicleDecodedInfo
import com.mirek.api.network.vehicleinfo.model.VehicleInfoResponse
import io.reactivex.Single

interface VehicleHtmlParserBackendApi {
    fun parseVehicleResponse(vehicleResponse: VehicleInfoResponse): Single<VehicleInfo>
}