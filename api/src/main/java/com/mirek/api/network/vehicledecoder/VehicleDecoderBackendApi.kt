package com.mirek.api.network.vehicledecoder

import com.mirek.api.network.vehicledecoder.model.VehicleDecodedInfo
import io.reactivex.Single

interface VehicleDecoderBackendApi {

    fun decodeAztecCode(aztec: String,
                        uniqueKey: String,
                        date: String): Single<VehicleDecodedInfo>
}