package com.pojazdo.api.network.vehicleinformation.model
import com.google.gson.annotations.SerializedName

data class VehicleOffers (

		@SerializedName("vehiclePrice") val price : String,
		@SerializedName("priceCurrency") val priceCurrency : String,
		@SerializedName("htmlUrl") val htmlUrl : String,
		@SerializedName("imgaeUrl") val imgaeUrl : String,
		@SerializedName("type") val type : String,
		@SerializedName("name") val name : String,
		@SerializedName("vehicleConfiguration") val vehicleConfiguration : String,
		@SerializedName("brand") val brand : String,
		@SerializedName("fuelType") val fuelType : String,
		@SerializedName("modelDate") val modelDate : Int,
		@SerializedName("unitCode") val unitCode : String,
		@SerializedName("value") val value : Int
)