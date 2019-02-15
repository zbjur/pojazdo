package com.mirek.usecases.vehiclehtmlparser

import com.mirek.api.network.htmlparser.VehicleHtmlParserBackendApi
import com.mirek.api.network.htmlparser.model.VehicleInfo
import com.mirek.api.network.vehicledecoder.VehicleDecoderBackendApi
import com.mirek.api.network.vehicledecoder.model.VehicleDecodedInfo
import com.mirek.api.network.vehicleinfo.model.VehicleInfoResponse
import io.reactivex.Single
import javax.inject.Inject

class VehicleHtmlParserService @Inject constructor(private val vehicleDecoderBackendApi: VehicleHtmlParserBackendApi) : VehicleHtmlParserApi {

    override fun parseVehicleResponse(vehicleResponse: VehicleInfoResponse): Single<VehicleInfo> {
        return vehicleDecoderBackendApi.parseVehicleResponse( vehicleResponse)
    }
}