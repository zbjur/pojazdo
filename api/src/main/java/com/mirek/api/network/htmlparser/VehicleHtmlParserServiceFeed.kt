package com.mirek.api.network.htmlparser

import com.mirek.api.network.htmlparser.model.VehicleInfo
import com.mirek.api.network.vehicledecoder.model.VehicleDecodedInfo
import com.mirek.api.network.vehicleinfo.model.VehicleInfoResponse
import io.reactivex.Single
import javax.inject.Inject

class VehicleHtmlParserServiceFeed @Inject constructor() : VehicleHtmlParserBackendApi {

    override fun parseVehicleResponse(vehicleResponse: VehicleInfoResponse): Single<VehicleInfo> {
        return Single.just(VehicleInfo("Info vehicle test"))
    }
}