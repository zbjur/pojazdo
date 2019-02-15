package com.mirek.api.network.vehicledecoder

import com.mirek.api.network.htmlparser.model.VehicleInfo
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface VehicleDecoderRetrofitApi{

    @GET("?format=json&groupId=\'home\'")
    fun getVehicleInfo(@Query("Country") country: String): Single<VehicleInfo>
}