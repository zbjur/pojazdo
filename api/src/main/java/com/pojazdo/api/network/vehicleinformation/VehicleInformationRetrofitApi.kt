package com.pojazdo.api.network.vehicleinformation

import com.pojazdo.api.network.vehicleinformation.model.VehicleInformation
import io.reactivex.Single
import retrofit2.http.*

interface VehicleInformationRetrofitApi {

    @FormUrlEncoded
    @POST("?format=json&groupId=\'home\'")
    fun checkVehicle(@Field("key") registrationNumber: String, @Query("vin") vin: String, @Query("dateOfFirstRegistration") dateOfFirstRegistration: String): Single<VehicleInformation>
}