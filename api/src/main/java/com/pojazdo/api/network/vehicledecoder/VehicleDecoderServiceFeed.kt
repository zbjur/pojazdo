package com.pojazdo.api.network.vehicledecoder

import com.pojazdo.api.network.vehicledecoder.model.VehicleDecodedInfo
import io.reactivex.Single
import io.reactivex.SingleEmitter
import javax.inject.Inject

class VehicleDecoderServiceFeed @Inject constructor() : VehicleDecoderBackendApi {

    override fun decodeAztecCode(aztec: String, uniqueKey: String, date: String): Single<VehicleDecodedInfo> {
        return Single.create<VehicleDecodedInfo>{
            emitter: SingleEmitter<VehicleDecodedInfo> ->
            emitter.onError(Throwable("my custom exception "))

        }
    }
}