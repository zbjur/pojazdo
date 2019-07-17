package com.pojazdo.usecases.vehicleaztecdecoder


import com.pojazdo.api.network.vehicledecoder.VehicleDecoderBackendApi
import com.pojazdo.api.network.vehicledecoder.model.VehicleDecodedInfo
import io.reactivex.Single
import javax.inject.Inject

class VehicleDecoderService @Inject constructor(private val vehicleDecoderBackendApi: VehicleDecoderBackendApi) : VehicleDecoderApi {

    override fun decodeAztecCode(aztec: String, uniqueKey: String, date: String): Single<VehicleDecodedInfo> {

        return vehicleDecoderBackendApi.decodeAztecCode(aztec, uniqueKey, date)
    }
}