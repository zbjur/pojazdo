package com.pojazdo.api.network.vehiclehtmlparser
import com.google.gson.annotations.SerializedName

data class TechnicalDataPojo (
	@SerializedName("engineCapacity") val engineCapacity : String,
	@SerializedName("enginePower") val enginePower : String,
	@SerializedName("fuelType") val fuelType : String,
	@SerializedName("coEmEmission") val coEmEmission : String,
	@SerializedName("averageFuelConsumption") val averageFuelCnsumption : String
)