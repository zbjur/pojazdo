package com.pojazdo.api.network.vehicleinformation.model
import com.google.gson.annotations.SerializedName

data class TimeLine (
	@SerializedName("date") val date : String,
	@SerializedName("descriptionList") val description : List<Description>
)