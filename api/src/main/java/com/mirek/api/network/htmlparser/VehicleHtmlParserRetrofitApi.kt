package com.mirek.api.network.htmlparser

import com.mirek.api.network.htmlparser.model.VehicleInfo
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface VehicleHtmlParserRetrofitApi{

    @GET("?format=json&groupId=\'home\'")
    fun getVehicleInfo(@Query("Country") country: String): Single<VehicleInfo>
}