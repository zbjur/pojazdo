package com.mirek.api.network.vehicledecoder.model

data class VehicleDecodedInfo(val registrationNumber: String,
                              val vin: String,
                              val firstRegistrationDate: String)