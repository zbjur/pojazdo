package com.pojazdo.api.network.vehicleinformation.model
import com.google.gson.annotations.SerializedName

data class VehicleAveragePrice (

	@SerializedName("maxPrice") val maxPrice : String,
	@SerializedName("minPrice") val minPrice : String,
	@SerializedName("averagePrice") val averagePrice : String
)