package com.pojazdo.api.network.vehicleinformation.model
import com.google.gson.annotations.SerializedName

data class Ratings (

		@SerializedName("title") val title : String,
		@SerializedName("rating") val rating : String,
		@SerializedName("ratingUrl") val ratingUrl : String
)