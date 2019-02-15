package com.mirek.common

import com.mirek.api.network.vehicledecoder.model.VehicleDecodedInfo


object VehicleDataFactory {

    val registrationNumber = ""

    val vin = ""

    val firstRegistrationDate = ""

    fun generateVehicleDecodedInfo() = VehicleDecodedInfo(registrationNumber, vin, firstRegistrationDate)
}