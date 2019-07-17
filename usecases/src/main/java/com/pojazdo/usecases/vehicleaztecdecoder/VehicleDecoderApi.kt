package com.pojazdo.usecases.vehicleaztecdecoder

import com.pojazdo.api.network.vehicledecoder.model.VehicleDecodedInfo
import io.reactivex.Single

interface VehicleDecoderApi {
    fun decodeAztecCode(aztec: String, uniqueKey: String, date: String): Single<VehicleDecodedInfo>
}