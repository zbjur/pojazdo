package com.pojazdo.api.network.vehicleinformation.model
import com.google.gson.annotations.SerializedName

data class VehicleRating (

		@SerializedName("overallRating") val overallRating : String,
		@SerializedName("overallTitle") val overallTitle : String,
		@SerializedName("buyAgainPercentage") val buyAgainPercentage : String,
		@SerializedName("buyAgainTitle") val buyAgainTitle : String,
		@SerializedName("ratings") val ratings : List<Ratings>,
		@SerializedName("engineRating") val engineRating : List<EngineRating>,
		@SerializedName("userRatings") val userRatings : List<UserRatings>
)