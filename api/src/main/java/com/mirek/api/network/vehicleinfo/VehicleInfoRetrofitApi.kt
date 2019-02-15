package com.mirek.api.network.vehicleinfo

import com.mirek.api.network.vehicleinfo.model.VehicleInfoResponse
import io.reactivex.Single
import retrofit2.http.*

interface VehicleInfoRetrofitApi {

    @FormUrlEncoded
    @POST("?format=json&groupId=\'home\'")
    fun checkVehicle(@Field("key") registrationNumber: String, @Query("vin") vin: String, @Query("dateOfFirstRegistration") dateOfFirstRegistration: String): Single<VehicleInfoResponse>
}