package com.pojazdo.api.network.vehicleinformation.model
import com.google.gson.annotations.SerializedName

data class TechnicalData (

		@SerializedName("engineCapacity") val engineCapacity : String,
		@SerializedName("enginePower") val enginePower : String,
		@SerializedName("fuelType") val fuelType : String,
		@SerializedName("coEmEmission") val coEmEmission : String,
		@SerializedName("totalCapacity") val totalCapacity : Int,
		@SerializedName("numberOfSeats") val numberOfSeats : Int,
		@SerializedName("curbWeight") val curbWeight : String
)