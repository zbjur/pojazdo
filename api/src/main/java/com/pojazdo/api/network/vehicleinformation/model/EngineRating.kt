package com.pojazdo.api.network.vehicleinformation.model
import com.google.gson.annotations.SerializedName

data class EngineRating (

		@SerializedName("engineName") val engineName : String,
		@SerializedName("rating") val rating : String,
		@SerializedName("url") val url : String
)