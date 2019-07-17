package com.pojazdo.api.network.vehicledecoder

import com.pojazdo.api.network.vehicledecoder.model.VehicleDecodedInfo
import io.reactivex.Single

interface VehicleDecoderBackendApi {
    fun decodeAztecCode(aztec: String,
                        uniqueKey: String,
                        date: String): Single<VehicleDecodedInfo>
}