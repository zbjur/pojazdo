package com.pojazdo.api.network.vehicleinfo

import com.pojazdo.api.network.vehicleinformation.model.VehicleInformationPojo
import io.reactivex.Single
import retrofit2.http.*

interface VehicleInfoRetrofitApi {

    @FormUrlEncoded
    @POST("?format=json&groupId=\'home\'")
    fun checkVehicle(@Field("key") registrationNumber: String, @Query("vin") vin: String, @Query("dateOfFirstRegistration") dateOfFirstRegistration: String): Single<VehicleInformationPojo>
}